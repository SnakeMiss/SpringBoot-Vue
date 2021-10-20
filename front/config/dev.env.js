'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  BASE_API: '"http://localhost:8888/"'
  
})
