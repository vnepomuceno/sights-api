# Sights API

## Endpoints

### `GET /sights`

Fetches all Sights from the database.

Request
```bash
http GET https://sights-api-stg.herokuapp.com/sights
```

Response
```json
[
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
  },
  {
    "author": {
      "id": "cca9fe4d60624d7cb1357057f9cfcd16",
      "source": "open-data"
    },
    "base": "http://tourism.citysdk.cm-lisboa.pt/pois/",
    "citySdkId": "52d7bf7a723e8e0b0cc090cf",
    "contact": null,
    "descriptions": null,
    "id": "59c43d26dd5e3d0a02433b49",
    "images": [
      {
        "href": "http://www.cm-lisboa.pt/uploads/pics/tt_address/lxi-1682-01.jpg",
        "id": "984dcd6fccdd42aabea2e45867ff328e",
        "type": "image/jpeg"
      }
    ],
    "labels": [
      {
        "id": "a598fb0fa3794942ba88f8e665cabc6c",
        "language": null,
        "term": "primary",
        "value": "Miradouro Mercado Chão de Loureiro"
      }
    ],
    "locations": null,
    "schedules": null,
    "websites": null
  }
]
```