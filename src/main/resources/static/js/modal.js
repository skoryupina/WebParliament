var modal = document.getElementById('modalForm');
var btnCreate = document.getElementById('createEntityButton');

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

btnCreate.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}


