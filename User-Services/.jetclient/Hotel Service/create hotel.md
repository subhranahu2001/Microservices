```toml
name = 'create hotel'
method = 'POST'
url = 'http://localhost:8086/hotels/create'
sortWeight = 1000000
id = '28baa6f3-4e3e-48de-a243-12825fee7aab'

[[headers]]
key = 'Content-Type'
value = 'application/json'

[body]
type = 'JSON'
raw = '''
{
  "name": "Mayfair",
  "location": "Bhubaneswar",
  "about": "Best Hotel In Odisha"
}'''
```
