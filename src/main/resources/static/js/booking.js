document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('bookingForm').addEventListener('submit', function(event) {
        event.preventDefault();
        var isValid = true;

        // Kiểm tra roomType
        var roomType = document.getElementById('roomType').value;
        if (!roomType) {
            document.getElementById('roomTypeError').innerText = "部屋タイプを選択してください。";
            isValid = false;
        } else {
            document.getElementById('roomTypeError').innerText = "";
        }

        // Kiểm tra stayType
        var stayType = document.getElementById('stayType').value;
        if (!stayType) {
            document.getElementById('stayTypeError').innerText = "タイプを選択してください。";
            isValid = false;
        } else {
            document.getElementById('stayTypeError').innerText = "";
        }

        // Kiểm tra checkInDate
        var checkInDate = document.getElementById('checkInDate').value;
        if (!checkInDate) {
            document.getElementById('checkInDateError').innerText = "チェックイン日を選択してください。";
            isValid = false;
        } else {
            document.getElementById('checkInDateError').innerText = "";
        }

        // Kiểm tra checkInTime
        var checkInTime = document.getElementById('checkInTime').value;
        if (!checkInTime) {
            document.getElementById('checkInTimeError').innerText = "チェックイン時間を選択してください。";
            isValid = false;
        } else if (stayType === "宿泊") {
            var checkInTimeObj = new Date('1970-01-01T' + checkInTime + ':00');
            var startTimeObj = new Date('1970-01-01T12:00:00');
            var endTimeObj = new Date('1970-01-01T19:59:00');
            if (checkInTimeObj > startTimeObj && checkInTimeObj < endTimeObj) {
                document.getElementById('checkInTimeError').innerText = "宿泊対象外時間です。確認してください。";
                isValid = false;
            } else {
                document.getElementById('checkInTimeError').innerText = "";
            }
        } else {
            document.getElementById('checkInTimeError').innerText = "";
        }

        // Kiểm tra numAdults
        var numAdults = document.getElementById('numAdults').value;
        if (numAdults < 1) {
            document.getElementById('numAdultsError').innerText = "大人の人数は少なくとも1人必要です。";
            isValid = false;
        } else {
            document.getElementById('numAdultsError').innerText = "";
        }

        // Kiểm tra numChildren
        var numChildren = document.getElementById('numChildren').value;
        if (numChildren < 0) {
            document.getElementById('numChildrenError').innerText = "子供の人数は負の数にできません。";
            isValid = false;
        } else {
            document.getElementById('numChildrenError').innerText = "";
        }

        // Kiểm tra fullName
        var fullName = document.getElementById('fullName').value;
        if (!fullName) {
            document.getElementById('fullNameError').innerText = "お名前を入力してください。";
            isValid = false;
        } else {
            document.getElementById('fullNameError').innerText = "";
        }

        // Kiểm tra phoneNumber
        var phoneNumber = document.getElementById('phoneNumber').value;
        if (!phoneNumber) {
            document.getElementById('phoneNumberError').innerText = "電話番号を入力してください。";
            isValid = false;
        } else {
            document.getElementById('phoneNumberError').innerText = "";
        }

        // Kiểm tra email
        var email = document.getElementById('email').value;
        var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
        if (!email) {
            document.getElementById('emailError').innerText = "メールを入力してください。";
            isValid = false;
        } else if (!emailPattern.test(email)) {
            document.getElementById('emailError').innerText = "メール形式が正しくありません。";
            isValid = false;
        } else {
            document.getElementById('emailError').innerText = "";
        }

        if (!isValid) {
            return;
        }

        var formData = {
            roomType: roomType,
            stayType: stayType,
            checkInDate: checkInDate,
            checkInTime: checkInTime,
            numAdults: numAdults,
            numChildren: numChildren,
            fullName: fullName,
            phoneNumber: phoneNumber,
            email: email,
            requests: document.getElementById('requests').value
        };

        fetch('/booking/submit', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
        .then(response => response.json())
        .then(data => {
            if (data.errors) {
                // Xử lý lỗi
            } else {
                document.getElementById('successMessage').innerText = data;
                document.getElementById('successPopup').style.display = 'block';
            }
        })
        .catch(error => console.error('Error:', error));
    });

    document.getElementById('closePopup').addEventListener('click', function() {
        document.getElementById('successPopup').style.display = 'none';
        window.location.reload(); // Làm mới trang sau khi đóng popup
    });
});
