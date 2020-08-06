// $(document).ready(function () {
$(function () {
    makeEditable({
            ajaxUrl: "ajax/profile/meals",
            datatableApi: $("#datatable").DataTable({
                "paging": false,
                "info": true,
                "columns": [
                    {
                        "data": "dateTime"
                    },
                    {
                        "data": "description"
                    },
                    {
                        "data": "calories"
                    },
                    {
                        "defaultContent": "Edit",
                        "orderable": false
                    },
                    {
                        "defaultContent": "Delete",
                        "orderable": false
                    }
                ],
                "order": [
                    [
                        0,
                        "asc"
                    ]
                ]
            }),updateTable: updateFilteredTable
        }
    );
});

function updateFilteredTable()
{
    $.ajax({
        type: "GET",
        url: context.ajaxUrl + "/filter",
        data: $("#filter").serialize()
    }).done(updateTableWithData)
}

function clearFilter()
{
    updateTable();
}