$('#btnBuy')[0].on('click', function () {
            $.ajax(
                {
                    url: "",
                    method: "POST",
                    data: { "type": "CPU", "ItemId": "@SelectedCPU.Id", "Quantity": parseInt($(this).parent().find('.value1').text(), 10) , "price": "@SelectedCPU.Price", "Id" : "@SelectedCPU.Id"},
                    success: function (response) {
                    }
                })
        });