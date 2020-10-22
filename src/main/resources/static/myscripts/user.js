$('document').ready(function () {
    let roles = $('#userRoles').text().trim().split(" ");
    $('#nav').prepend('<li class="nav-item"><a class="nav-link border rounded" href="/admin/users">Admin</a></li>');
})
