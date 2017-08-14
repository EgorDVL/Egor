'use strict';
let webpack = require('webpack');
let path = require('path');
let ExtractTextPlugin = require('extract-text-webpack-plugin');
module.exports = {

    entry: {
        app: '/home/user/IdeaProjects/InitialTask_Task_4/src/main/webapp/js/ECMAScript_6/app.js'
    },
    externals: {
        jQuery: 'jquery',
    },

    plugins: [
        new webpack.ProvidePlugin({
            $: 'jquery',
            jQuery: 'jquery',
        }),
        new ExtractTextPlugin('./main.css')
    ],

    output: {
        path: '/home/user/IdeaProjects/InitialTask_Task_4/src/main/webapp/js/ECMAScript_6/outputJs',
        filename: 'bundle.js'
    },
    resolve: {
        modules: [
            path.join('src/main/webapp', "node_modules"),
            "node_modules"
        ],
        extensions: ['.js', '.css']
    },

    module: {
        rules: [
            {
                test: /\.css$/,
                use: ExtractTextPlugin.extract({
                    use: 'css-loader'
                })
            },
            {
                test: require.resolve('jquery'),
                loader: 'expose-loader?jQuery!expose-loader?$'
            },
            {
                test: /\.js$/,
                exclude: [/node_modules/],
                use: [{
                    loader: 'babel-loader',
                    options: {
                        presets: [
                            ['es2015', {modules: false}],
                            'stage-0',
                            "env"
                        ],
                    }
                }],
            },
        ],
    },
    devtool: 'cheap-module-eval-source-map'
};