```toml
name = 'save User'
method = 'POST'
url = 'http://localhost:8085/users/save'
sortWeight = 1000000
id = 'f34dec62-17ea-4db7-980d-533fb18b859d'

[[headers]]
key = 'Content-Type'
value = 'application/json'

[body]
type = 'JSON'
raw = '''
{
  "name": "Thor",
  "email": "thor@gmail.com",
  "about": "superhero"
}'''
```
