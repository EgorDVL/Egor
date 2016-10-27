/**
 * Created by Egor on 26.10.2016.
 */
$(document).ready(function () {
    var phones = $("#phones");
    var tablets = $("#tablets");
    var accessories = $("#accessories");

    $("#phones-header").on('click', function () {
        phones.slideToggle();
    });

    $("#tablets-header").on('click', function () {
        tablets.slideToggle();
    });

    $("#accessories-header").on('click', function () {
        accessories.slideToggle();
    });

});