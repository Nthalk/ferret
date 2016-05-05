# Postgres
class { 'postgresql::server':
  ip_mask_allow_all_users    => '0.0.0.0/0',
  listen_addresses           => '*',
}

postgresql::server::db { 'ferret':
  user     => 'ferret',
  password => postgresql_password('ferret', 'ferret'),
}

# apt
package { 'python-software-properties':
  ensure => 'installed',
}

# NGINX
package { "nginx":
  ensure => "installed",
}

service { "nginx":
  ensure => "running",
}

file { "/etc/nginx/nginx.conf":
  notify  => Service["nginx"],
  source  => "puppet:///files/nginx/nginx.conf",
  recurse => true,
  require => Package["nginx"],
}



