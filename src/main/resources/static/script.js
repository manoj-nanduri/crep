document.addEventListener('DOMContentLoaded', function () {
    var uploadBtn = document.querySelector('.upload-btn');
    var fileInput = document.getElementById('file');
    var form = document.getElementById('upload-form');
    var label = form.querySelector('label[for="file"]');
    var messageBoxes = document.querySelectorAll('.message-box');

    // Function to clear messages
    function clearMessages() {
        // Hide all message boxes
        messageBoxes.forEach(function(box) {
            box.style.display = 'none';
        });
    }

    uploadBtn.addEventListener('click', function() {
        if (uploadBtn.textContent === "Trigger Replay") {
            uploadBtn.textContent = "Processing...";
            form.submit(); // If "Trigger Replay" is shown, submit the form
        } else {
            clearMessages();
            fileInput.disabled = false; // Enable the file input
            fileInput.click(); // Trigger the file input
        }
    });

    fileInput.addEventListener('change', function() {
        if (this.files.length > 0) {
            var fileName = this.files[0].name;
            label.textContent = "File selected: " + fileName + ". Click Trigger Replay";
            uploadBtn.textContent = "Trigger Replay";
            uploadBtn.type = "submit"; // Change button type to submit to enable form submission
            form.classList.remove('form-disabled'); // Make the form clickable
        }
    });

    form.addEventListener('submit', function(event) {
        //event.preventDefault(); // Prevent default form submission
    });
});
