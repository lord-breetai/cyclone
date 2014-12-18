(function (window) {
    if (window.UICyclone) {
        return;
    }

    var UICyclone = {
        escapeClientId: function (id) {
            return "#" + id.replace(/:/g, "\\:");
        }
    };

    window.UICyclone = UICyclone;
})(window);

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