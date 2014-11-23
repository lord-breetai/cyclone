
UICyclone.formRow = {
    putForAttrLabel: function (id) {
        var labelId = id + "_label",
            contentTdId = id + "_content";

        var label = $(UICyclone.escapeClientId(labelId)),
            contentTd = $(UICyclone.escapeClientId(contentTdId));

        var firstInput = contentTd.find(':input:enabled:first');

        if (firstInput) {
            label.prop('for', firstInput.prop('id'));
        }
    }
};