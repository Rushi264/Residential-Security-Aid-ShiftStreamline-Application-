document.addEventListener('DOMContentLoaded', function() {
    const navLinks = document.querySelectorAll('nav ul li a');
    const currentLocation = window.location.href;

    navLinks.forEach(link => {
        if (link.href === currentLocation) {
            link.classList.add('active');
        }
        link.addEventListener('mouseover', () => {
            link.style.backgroundColor = '#003f5c'; // Darken the color on hover
        });
        link.addEventListener('mouseout', () => {
            link.style.backgroundColor = ''; // Reset on mouse out
        });
    });

    // Smooth scrolling for all anchors
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function(e) {
            e.preventDefault();

            document.querySelector(this.getAttribute('href')).scrollIntoView({
                behavior: 'smooth'
            });
        });
    });
});


function loadContent(url) {
    fetch(url)
    .then(response => response.text())
    .then(html => {
        document.querySelector('main').innerHTML = html;
    })
    .catch(error => console.error('Failed to load the page: ', error));
}

document.querySelectorAll('nav ul li a').forEach(link => {
    link.addEventListener('click', function(e) {
        e.preventDefault();
        const url = this.href;
        loadContent(url);
    });
});
