$('document').ready(function () {
    let roles = $('#userRoles').text().trim().split(" ");
    if (roles == 'USER') {
        $('#nav').prepend('<li class="nav-item"><a class="nav-link active border rounded" href="/user">User</a></li>');
    } else {
        $('#nav').prepend('<li class="nav-item"><a class="nav-link border rounded" href="/admin/users">Admin</a></li>');
    }
})