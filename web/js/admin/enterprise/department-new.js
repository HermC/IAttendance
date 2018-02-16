'use strict';

(function() {
    init();

    function init() {
        $('#department_new_submit').on('click', function() {
            var data = $('#department_new_form').serialize();
            $.ajax({
                url: '/admin/enterprise/department/new',
                type: 'POST',
            });
        });
    }
})();