<template>
  <div>
    <!--表格栏-->
    <el-table :data="data.content" stripe highlight-current-row @selection-change="selectionChange" 
      @current-change="handleCurrentChange" :v-loading="loading" :max-height="maxHeight" :size="size" :align="align" style="width:100%;" >
      <el-table-column type="selection" width="50"></el-table-column>
      <el-table-column v-for="column in columns" 
        :prop="column.prop" :label="column.label" :width="column.width" :min-width="column.minWidth" 
        :sortable="column.sortable" :fixed="column.fixed" :key="column.prop" :type="column.type">
      </el-table-column>
      <el-table-column label="操作" width="150" fixed="right">
        <template slot-scope="scope">
          <KtButton label="编辑" :perms="permsDelete" :size="size" type="primary" @click="handleEdit(scope.$index, scope.row)"></KtButton>
          <KtButton label="授权" :perms="permsDelete" :size="size" type="primary" @click="handleAuth(scope.$index, scope.row)"></KtButton>
        </template>
      </el-table-column>
    </el-table>
    <!--分页栏-->
    <div class="toolbar" style="padding:10px;">
     <!--<KtButton label="批量删除" :perms="permsDelete" :size="size" type="danger" @click="handleBatchDelete()" 
        :disabled="this.selections.length===0" style="float:left;"></KtButton>
        -->
      <el-pagination layout="total, prev, pager, next, jumper" @current-change="refreshPageRequest" 
        :current-page="pageRequest.pageNum" :page-size="pageRequest.pageSize" :total="data.totalSize" style="float:right;">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import KtButton from "@/views/Core/KtButton"
export default {
  name: 'KtTable',
  components:{
            KtButton
    },
  props: {
    columns: Array, // 表格列配置
    data: Object, // 表格分页数据
    permsEdit: String,  // 编辑权限标识
    permsDelete: String,  // 删除权限标识
    size: { // 尺寸样式
      type: String,
      default: 'mini'
    },
    align: {  // 文本对齐方式
      type: String,
      default: 'left'
    },
    maxHeight: {  // 表格最大高度
      type: Number,
      default: 420
    }
  },
  data() {
    return {
      // 分页信息
            pageRequest: {
                pageNum: 1,
        pageSize: 8
      },
      loading: false,  // 加载标识
      selections: []  // 列表选中列
    }
  },
  methods: {
    // 分页查询
    findPage: function () {
      this.$emit('findPage', {pageRequest:this.pageRequest})
    },
    // 选择切换
    selectionChange: function (selections) {
            this.selections = selections
    },
    // 选择切换
    handleCurrentChange: function (val) {
      this.$emit('handleCurrentChange', {val:val})
    },
    // 换页刷新
        refreshPageRequest: function (pageNum) {
      this.pageRequest.pageNum = pageNum
      this.findPage()
    },
    // 编辑
      handleEdit: function (index, row) {
      this.$emit('handleEdit', {index:index, row:row})
        },

   // 授权
      handleAuth: function (index, row) {
      this.$emit('handleAuth', {index:index, row:row})
        },


    // 删除
        handleDelete: function (index, row) {
            this.delete(row.id)
        },
        // 批量删除
        handleBatchDelete: function () {
            let ids = this.selections.map(item => item.id).toString()
            this.delete(ids)
        },
        // 删除操作
        delete: function (ids) {
            this.$confirm('确认删除选中记录吗？', '提示', {
                type: 'warning'
            }).then(() => {
                let params = []
                let idArray = (ids+'').split(',')
                for(var i=0; i<idArray.length; i++) {
                    params.push({'id':idArray[i]})
        }
        let callback = res => {
          this.$message({message: '删除成功', type: 'success'})
          this.findPage()
        }
        this.$emit('handleDelete', {params:params, callback:callback})
            }).catch(() => {
            })
        }
  },
  mounted() {
    this.refreshPageRequest(1)
  }
}
</script>

<style scoped>

</style>