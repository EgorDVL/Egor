/**
 * Created by Egor on 11.04.2017.
 */

$(document).ready(function () {
    toggleInput();

    $('[name=type]').on('change', toggleInput);
});

function toggleInput() {
    var $typeValue = $('[name=typeValue]');
    var selectValue = $('[name=type]').val();
    if (selectValue === 'CHECK_BOX' || selectValue === 'COMBO_BOX' || selectValue === 'RADIO_BUTTON') {
        $typeValue.attr('required', 'required');
        $typeValue.show();
    } else {
        $typeValue.hide();
    }
}



