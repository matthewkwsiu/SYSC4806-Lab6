$(function() {
    $.ajax({
        url: "http://localhost:8080/viewaddressbook",
        dataType: "json",
    }).then(function (data) {
        myFunction(data);
        // $('.greeting-id').append(data);
        // $('.greeting-content').append(data.content);
    });

    function myFunction(data) {

        // console.log(data[0].id);
        // console.log("data.number");

    }

    $("#viewAddressBookForm").on('submit', function(e){
        e.preventDefault();
        e.returnValue = false;
        document.getElementById("visible").style.visibility = "visible";
        console.log($("#AddressBookID").val());

        $.ajax({
            url: "http://localhost:8080/getaddressbook?id=" + $("#AddressBookID").val(),
            dataType: "json",
        }).then(function (data) {

            console.log(data);

            for(var key in data.buddies){
                $('#myTable').append('<tr><td>'+data.buddies[key].name+'</td><td>'+data.buddies[key].address+'</td><td>'+data.buddies[key].phoneNumber+'</td></tr>');

            }
            // key of data.buddies
        });


    })

    $("#addBuddyInfoForm").on('submit', myFunction2);

    function myFunction2(e){
            e.preventDefault();
            e.returnValue = false;
            document.getElementById("visible").style.visibility = "visible";
            console.log($("#AddressBookID2").val());
            console.log($("#BuddyInfoID").val());
            console.log($("#BuddyInfoAddress").val());
            console.log($("#BuddyInfoPhoneNumber").val());

            //     $.ajax({
            //         url: "http://localhost:8080/buddyinfo?addressBookIndex=" + ($("#AddressBookID2").val()-1) + "&name=" + $("#BuddyInfoID").val() + "&address=" + $("#BuddyInfoAddress").val() + "&phoneNumber=" +$("#BuddyInfoPhoneNumber").val(),
            //         dataType: "json"
            //
            // })
            $.post("http://localhost:8080/buddyinfo?addressBookIndex=" + ($("#AddressBookID2").val()-1) + "&name=" + $("#BuddyInfoID").val() + "&address=" + $("#BuddyInfoAddress").val() + "&phoneNumber=" +$("#BuddyInfoPhoneNumber").val());

            $.ajax({
                url: "http://localhost:8080/getaddressbook?id=" + $("#AddressBookID2").val(),
                dataType: "json"
            }).then(function (data) {
                // console.log(data.id);
                $('#myTable').append('<tr><td>'
                    +$("#BuddyInfoID").val()+
                    '</td>' +
                    '<td>'+$("#BuddyInfoAddress").val()+'</td>' +
                    '<td>'+$("#BuddyInfoPhoneNumber").val()+
                    '</td></tr>');
                    // var abc = $(document.createElement("tr"));
                    // abc.appendChild(document.createElement("td"));

            });

    }


});