// Ottieni gli elementi del pop-up
var modal = document.getElementById("infoModal");
var span = document.getElementsByClassName("close")[0];
var infoBtn = document.getElementById("infoBtn");

// Funzione per aprire il pop-up
infoBtn.onclick = function() {
    modal.style.display = "block";
}

// Funzione per chiudere il pop-up
span.onclick = function() {
    modal.style.display = "none";
}

// Chiudere il pop-up se si clicca fuori dal pop-up
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
