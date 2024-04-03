[![Community badge: Incubating](https://img.shields.io/badge/Lifecycle-Incubating-blue)](https://github.com/Camunda-Community-Hub/community/blob/main/extension-lifecycle.md#incubating-)
[![Community extension badge](https://img.shields.io/badge/Community%20Extension-An%20open%20source%20community%20maintained%20project-FF4700)](https://github.com/camunda-community-hub/community)

# Web Modeler CLI

Command line interface for [Web Modeler API](https://docs.camunda.io/docs/apis-clients/web-modeler-api/).

Early stages of development.

## Usage

```
Usage: <main class> [-hV] [--audience=<audience>] [--authType=<authType>]
                    [--authUrl=<authUrl>] [-b=<baseUrl>]
                    [--clientId=<clientId>] [--clientSecret=<clientSecret>]
                    [-t=<token>] [COMMAND]
Web Modeler CLI
      --audience=<audience> audience of API (default to Camunda Saas audience)
      --authType=<authType> auth type, only required for self-managed (default
                              to KEYCLOAK)
      --authUrl=<authUrl>   auth url of API (default to Camunda Saas auth url)
  -b, --baseUrl, --basePath=<baseUrl>
                            base url of API (default to Camunda Modeler Saas
                              url)
      --clientId=<clientId> client id
      --clientSecret=<clientSecret>
                            client secret
  -h, --help                Show this help message and exit.
  -t, --token=<token>       JWT token
  -V, --version             Print version information and exit.
Commands:
  info             Prints out info (permissions, authorized organization).
  listProjects     Prints out projects in the organization.
  listFiles        Prints out files in project (only metadata, no file
                     contents).
  downloadFile     Prints out file content.
  downloadProject  Downloads all files of the project.

```

Program will print out usage help for each subcommand.

### Download Project

```
Usage: <main class> downloadProject [-hV] [--audience=<audience>]
                                    [--authType=<authType>]
                                    [--authUrl=<authUrl>] [-b=<baseUrl>]
                                    [--clientId=<clientId>]
                                    [--clientSecret=<clientSecret>] [-m=<mode>]
                                    [-o=<output>] -p=<projectUUID> [-t=<token>]
Downloads all files of the project.
      --audience=<audience> audience of API (default to Camunda Saas audience)
      --authType=<authType> auth type, only required for self-managed (default
                              to KEYCLOAK)
      --authUrl=<authUrl>   auth url of API (default to Camunda Saas auth url)
  -b, --baseUrl, --basePath=<baseUrl>
                            base url of API (default to Camunda Modeler Saas
                              url)
      --clientId=<clientId> client id
      --clientSecret=<clientSecret>
                            client secret
  -h, --help                Show this help message and exit.
  -m, --mode=<mode>         Overwrite mode for download. Valid values are:
                              SIMPLE_PATH, CANONICAL_PATH
  -o, --output=<output>     output folder
  -p, --project=<projectUUID>
                            project UUID
  -t, --token=<token>       JWT token
  -V, --version             Print version information and exit.

```

**Mode**

* `SIMPLE_PATH` - Recommended if you have unique folder and file names in your project. It uses the simple path to
  create files. If a folder name is ambiguous, all folders with the same name get merged. If files are ambiguous, they
  overwrite each other and the last file wins
* `CANONICAL_PATH` - Recommended if your folder and file names are not unique. It uses the canonical path. Each folder
  and file name is suffixed by its unique ID (i.e. `<name>[<id>]`). This makes names unique, but also less pleasant to
  look at.

## Building from source

```sh
mvn package
cd target/
java -jar web-modeler-cli-*-jar-with-dependencies.jar --help
```

## Contributing

* [Contributing Guide](./CONTRIBUTING.md)
* [Code of Conduct](./CODE_OF_CONDUCT.md)
