$(document).ready(function () {

    var audience = {
        applyId: $('#applyId').val(),
        aRecruits: $('#aRecruits').val()
    }

    //응모인원 리스트 출력 ajax
    $('#showList').click(function () {
        $.ajax({
            url: "/audience/showList",
            type: "get",
            dataType: 'json',
            data: audience,
            success: function (data) {
                var tableData = "";
                $.each(data, function (key, value) {
                    tableData += '<tr>';
                    tableData += '<td>' + value.name + '</td>';
                    tableData += '<td>' + value.phone + '</td>';
                    tableData += '</tr>';
                });
                $("#list").append(tableData);
            },
            error: function (request, status, error) {
                alert("code = " + request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
            }
        });
    })

    $('#showResult').click(function () {
        $.ajax({
            url: "/audience/showResult",
            type: "get",
            dataType: 'json',
            data: audience,
            success: function (data) {
                var tableData = "";
                $.each(data, function (key, value) {
                    tableData += '<tr>';
                    tableData += '<td>' + value.name + '</td>';
                    tableData += '<td>' + value.phone + '</td>';
                    tableData += '</tr>';
                });

                $("#list").append(tableData);

            },
            error: function (request, status, error) {
                alert("code = " + request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
            }
        });
    })





})


