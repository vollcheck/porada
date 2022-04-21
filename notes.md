## Interesting links

- https://clojuredocs.org/clojuredocs-export.json -- use that as a data for application


## Retrieving the data

In order to retrieve the data of functions, I used `jq` (https://github.com/stedolan/jq).

clojuredocs.org's exported JSON has the following structure:

```json
{
  "created-at": 1650478707980,
  "description" : "ClojureDocs Data Export",
  "vars": [
    ...
  ]
}
```

So I just needed to perform following operation:

```console
$ jq '.["vars"]' clojuredocs-export.json > vars.json
```


## Further plans

- Introduce a database?
- Work on the frontend
