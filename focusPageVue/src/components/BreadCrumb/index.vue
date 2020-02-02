<template>
  <el-breadcrumb separator="/" class="breadcrumb">
    <el-breadcrumb-item v-for="item in $route.matched" :key="item.path">
      <a href="www.baidu.com">{{ item.name }}</a>
    </el-breadcrumb-item>
  </el-breadcrumb>
</template>

<script>
export default {
  data() {
    return {
    };
  },
  methods: {

  },
  mounted() {

  }
};
</script>

<style scoped lang="scss">
.breadcrumb {
  padding: 10px;  
  border-color: rgba(38, 86, 114, 0.2);
  border-bottom-width: 1px;
  border-bottom-style: solid;
  // background: rgba(180, 189, 196, 0.1);
}
</style>