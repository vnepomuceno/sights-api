# Sights API

![Build Status](https://travis-ci.com/Vnepomuceno/sights-api.svg?token=qYT5CezVQyhwycXS4dtu&branch=master)

## Environments

- Development: https://sights-api-dev.herokuapp.com

## Endpoints

### `GET /sights`

Returns a list of all Sights with overview information.

Request
```bash
http GET <BASE_URL>/sights
```

Response
```json
[
  {
    "id": "59c43d1bdd5e3d0a02433b47",
    "name": "Miradouro do Jardim Botânico da Ajuda",
    "cover_photo": "4AAQSkZJRgABAQEASABIAAD/2wBDAAgGBgcGBQgHBwcJCQgKD",
    "distance_from_user_meters": 3700,
    "user_arrives_in_minutes": 20,
    "rating": 4.5,
    "favorites": 18
  },
  {
      "id": "59c43d1bdd5e3d0a02433b47",
      "name": "Miradouro Mercado Chão de Loureiro",
      "cover_photo": "AhEBAxEB/8QAHwAAAQUBAQEBAQEAAcAKAECAwQFBgcICQoL",
      "distance_from_user_meters": 1200,
      "user_arrives_in_minutes": 8,
      "rating": 3.1,
      "favorites": 12
    }
]
```
---

### `GET /sights/:id`

Complete information about a Sight with `id`.

Request
```bash
http GET <BASE_URL>/sights/59c43d27dd5e3d0a02433b4c
```

Response
```json
{
  "author": {
    "id": "31ab7bf08f4247f08a7755630a9e2561",
    "source": "open-data"
  },
  "base": "http://tourism.citysdk.cm-lisboa.pt/pois/",
  "citySdkId": "52d7bf7d723e8e0b0cc09138",
  "contact": null,
  "descriptions": null,
  "id": "59c43d1bdd5e3d0a02433b47",
  "images": null,
  "labels": [
    {
      "id": "0f25c629ced04ac4913fafcbe1903dc9",
      "language": null,
      "term": "primary",
      "value": "Miradouro do Jardim Botânico da Ajuda"
    }
  ],
  "locations": null,
  "schedules": null,
  "websites": null
}
```
---

### `POST /sights/:id/rate`

Submits a rating for a Sight with `id`.

Request
```bash
http POST <BASE_URL>/sights/59c43d27dd5e3d0a02433b4c/rate rating=3 
```
---

### `POST /sights/:id/favorite`

Submits a favorite for a Sight with `id`.

Request
```bash
http POST <BASE_URL>/sights/59c43d27dd5e3d0a02433b4c/favorite
```
---

### `POST /feedback`

Submits a feedback suggestion.

Request
```bash
http POST <BASE_URL>/feedback
```
---

### `POST /users/:email/login`

Logs user in with `email`.

---

### `POST /users/register`

Registers user.

---
