export default class Error {
    constructor() {};

    error(err) {
        let message = JSON.parse(err.responseText);
        $('#error').text(message.msg);
    }

    errorDuplicateName(err) {
        let message = JSON.parse(err.responseText);
        $('#errMess').text(message.name);
    }

    errorDuplicateEmail(err) {
        let message = JSON.parse(err.responseText);
        $('#errMessEmployee').text(message.email);
    }
}