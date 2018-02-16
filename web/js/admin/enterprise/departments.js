'use strict';

(function() {
    init();

    function init() {
        $('#arrive_time, #leave_time').daterangepicker({
            timePicker: true,
            timePicker24Hour: true,
            timePickerIncrement: 5,
            locale: {
                format: 'HH:mm',
                applyLabel: '确认',
                cancelLabel: '取消'
            },
            opens: 'left',
            dateLimit: {
                days: 1
            }
        }, function(start, end, label) {
            console.log('New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')');
        });

        $('#arrive_time, #leave_time').on('apply.daterangepicker', function(ev, picker) {
            console.log($('#arrive_time').data('daterangepicker').startDate.format('HH:mm'));
        });

        var table = $('#department_table').DataTable({
            //是否显示"处理中"
            processing: true,
            //是否使用服务器端数据
            serverSide: true,
            //展示完全的页码
            pagingType: 'full_numbers',
            //第一列默认升序排列
            order: [[0, 'asc']],
            //自定义中文显示
            language: {
                url: '/resource/i18n/dataTables-zh-cn.json'
            },
            //表格映射
            columns: [
                { data: "id" },
                { data: "name" },
                { data: "opt" }
            ],
            //ajax
            ajax: {
                url: '/admin/enterprise/department',
                type: 'POST',
                data: function(d) {
                    return $.extend({}, d, {
                        department_id: $('#department_id').val(),
                        department_name: $('#department_name').val()
                    })
                },
                dataSrc: function(json) {
                    console.log(json);
                    var data = json.data;
                    //给新数据添加操作
                    for (var i = 0; i < data.length; i++) {
                        data[i]['opt'] = '<a href="#">' +
                            '   <i class="fa fa-edit"></i>' +
                            '</a>' +
                            '<a href="#">' +
                            '   <i class="fa fa-trash"></i>' +
                            '</a>';
                    }
                    return data;
                },
                error: function() {
                    console.log('Network error');
                }
            }
        });

        $('#department_search').on('click', function() {
            table.ajax.reload(null, false);
        })
    }

    function loadTable() {

    }
}());