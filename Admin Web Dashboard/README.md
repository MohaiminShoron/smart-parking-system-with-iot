
### Installation

``` bash
$ npm install
```

or

``` bash
$ yarn install
```

### Basic usage

``` bash
# dev server with hot reload at http://localhost:3000
$ npm run dev
```

or 

``` bash
# dev server with hot reload at http://localhost:3000
$ yarn dev
```

Navigate to [http://localhost:3000](http://localhost:3000). 
#### Build

Run `build` to build the project. The build artifacts will be stored in the `build/` directory.

```bash
# build for production with minification
$ npm run build
```

or

```bash
# build for production with minification
$ yarn build
```

## Directories


```
Admin Web Dashboard
├── public/          # static files
├── src/             # project root
│   ├── assets/      # images, icons, etc.
│   ├── components/  # common components - header, footer, sidebar, etc.
│   ├── layouts/     # layout containers
│   ├── scss/        # scss styles
│   ├── router       # routes config
│   ├── store        # template state example 
│   ├── views/       # application views
│   ├── _nav.js      # sidebar navigation config
│   ├── App.vue
│   ├── ...
│   └── main.js
├── index.html   # html template
├── package.json
└── vite.config.js
```
