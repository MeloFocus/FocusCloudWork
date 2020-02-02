module.exports = {
    proxyList: {
    '/': {
    // 测试环境
    target: 'http://47.98.153.30:18900',
    changeOrigin: true, //是否跨域
    pathRewrite: {
    '^/': '' //需要rewrite重写的,
    }
    }
  }
}