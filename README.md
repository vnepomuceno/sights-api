# Sights API

![Build Status](https://travis-ci.com/Vnepomuceno/sights-api.svg?token=qYT5CezVQyhwycXS4dtu&branch=master)

## Environments

- Development: https://sights-api-dev.herokuapp.com

## Running API Locally

Run MongoDB instance in Docker:

```
docker-compose up -d mongo
```

Run Sights API instance in Docker:

```
docker-compose build dev && docker-compose run dev
```

## API Documentation

After running Sights API locally, open in the browser http://localhost:8080/swagger-ui.html.