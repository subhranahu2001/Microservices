```toml
name = 'create Ratings'
method = 'POST'
url = 'http://localhost:8087/ratings/create'
sortWeight = 1000000
id = '9d3d86f7-e1e9-4e16-8e1e-0cbe8b1e60a8'

[[headers]]
key = 'Content-Type'
value = 'application/json'

[body]
type = 'JSON'
raw = '''
{
  "userId": "6c5b5616-000a-4049-b2b8-725a8755800c",
  "hotelId": "8c648b87-409b-4471-9feb-c188140c65df",
  "rating": 6,
  "feedback": "This Hotel is not up to the expectations"
}'''
```
