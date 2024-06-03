document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('confirmButton').addEventListener('click', function(event) {
        event.preventDefault();

        const form = document.getElementById('confirmForm');
        const formData = new FormData(form);
        const jsonData = {};
        formData.forEach((value, key) => {
            jsonData[key] = value;
        });

        fetch('/booking/submit', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(jsonData)
        })
        .then(response => response.text())
        .then(data => {
            document.getElementById('successMessage').innerText = data;
            document.getElementById('successPopup').style.display = 'block';
        })
        .catch(error => console.error('Error:', error));
    });

    document.getElementById('closePopup').addEventListener('click', function() {
        document.getElementById('successPopup').style.display = 'none';
        window.location.href = '/booking';
    });
});
