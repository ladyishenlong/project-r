<template>
  <div>
    <h1>这里是测试页面了</h1>
    <Button type="info" @click="getArticleIndex">Info</Button>
  </div>
</template>

<script>
  export default {
    name: "TestPage",
    methods: {
      getArticleIndex() {
        this.$axios.get("http://localhost:8003/article/article/findArticleIndexByUsername",
          {
            headers: {
              'Content-Type': 'application/json;charset=UTF-8',
              'x-auth-token': document.cookie
            },
          })

          .then((result) => {
            console.log("请求成功" + JSON.stringify(result.data))
          })
          .catch((error) => {
            console.log("请求失败" + error)
          })
      }
    }
  }
</script>


<style scoped>

</style>
