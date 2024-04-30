document.addEventListener('DOMContentLoaded', function() {
    const menuToggle = document.createElement('button');
    menuToggle.innerText = 'Menu';
    menuToggle.addEventListener('click', () => {
        const nav = document.querySelector('nav ul');
        if (nav.style.display === 'block') {
            nav.style.display = 'none';
        } else {
            nav.style.display = 'block';
        }
    });

    document.querySelector('header').appendChild(menuToggle);
});
