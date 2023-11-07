document.addEventListener('DOMContentLoaded', function () {
    var uploadBtn       = document.querySelector('.upload-btn');
    var fileInput       = document.getElementById('file');
    var form            = document.getElementById('upload-form');
    var label           = form.querySelector('label[for="file"]');
    var messageBoxes    = document.querySelectorAll('.message-box');

    function clearMessages() {
        messageBoxes.forEach(function(box) {
            box.style.display = 'none';
        });
    }

    uploadBtn.addEventListener('click', function() {
        if (uploadBtn.textContent === "Trigger Replay") {
            form.submit();
        } else {
            clearMessages();
            fileInput.disabled = false;
            fileInput.click();
        }
    });

    fileInput.addEventListener('change', function() {
        if (this.files.length > 0) {
            var fileName = this.files[0].name;
            label.textContent = "File selected: " + fileName + ". Click Trigger Replay";
            uploadBtn.textContent = "Trigger Replay";
            uploadBtn.type = "submit";
            form.classList.remove('form-disabled');
        }
    });

    form.addEventListener('submit', function(event) {
        //event.preventDefault();
    });
});
