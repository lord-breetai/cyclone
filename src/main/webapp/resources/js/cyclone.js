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