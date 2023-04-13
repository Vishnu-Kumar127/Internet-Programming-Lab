$(document).ready(function() {
    $.ajax({
        type: "GET",
        url: "products.xml",
        dataType: "xml",
        success: function(xml) {
            $(xml).find('product').each(function() {
                var name = $(this).find('name').text();
                var description = $(this).find('description').text();
                var price = $(this).find('price').text();
                var image = $(this).find('image').text();

                var row = $('<tr></tr>');
                row.append($('<td></td>').html(name));
                row.append($('<td></td>').html(description));
                row.append($('<td></td>').html(price));

                $('#productTable tbody').append(row);

                row.click(function() {
                    $('#productName').html(name);
                    $('#productDescription').html(description);
                    $('#productPrice').html(price);
                    $('#productImage').attr('src', image);
                    $('#productModal').show();
                });
            });
        },
        error: function() {
            alert("Error loading products!");
        }
    });

    $('.close').click(function() {
        $('#productModal').hide();
    });

    $(document).on('click', function(event) {
        if ($(event.target).is('#productModal')) {
            $('#productModal').hide();
        }
    });
});
