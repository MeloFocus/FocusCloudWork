<template>
  <!--当前页面仅用于展示资源管理菜单栏-->
  <!--资源菜单，表格树内容栏-->
	<div class="menu-container" :v-if="true">
		<div class="menu-header">
			<span><B>资源菜单授权</B></span>
		</div>
        <el-tree :data="menuData" size="mini" show-checkbox node-key="id" :props="defaultProps"
			style="width: 100%;pading-top:20px;" ref="menuTree" :render-content="renderContent"
			v-loading="menuLoading" element-loading-text="拼命加载中" :check-strictly="true"
			@check-change="handleMenuCheckChange">
	    </el-tree>
	</div>
</template>
<script>
import qs from 'qs';
export default {
    data() {
        return {
            selectRole: {},
			menuData: [],
		    menuSelections: [],
			menuLoading: false,
			authLoading: false,
			checkAll: false,
			currentRoleMenus: [],
			defaultProps: {
			children: 'childrenList',
			label: 'name'
			}
        }
    },
    methods: {
		// 获取资源菜单数
		findResourceTree: function () {
			this.menuLoading = true
			this.$api.role.findResourceTree().then((res) => {
        if(res.status == 502){
           this.$message({ message: res.data, type: 'error' })
           return
        }else if(res.status == 200){
          //将后台传来的数据进行转换。转换成所需要的的数据 
          this.menuData = res.data
        }
				this.menuLoading = false
			})
		},
		// 角色选择改变监听
		handleRoleSelectChange(val) {
			if(val == null || val.val == null) {
				return
			}
			this.selectRole = val.val
			this.$api.role.findRoleMenus({'roleId':val.val.id}).then((res) => {
				this.currentRoleMenus = res.data
				this.$refs.menuTree.setCheckedNodes(res.data)
			})
		},
		// 树节点选择监听
		handleMenuCheckChange(data, check, subCheck) {
			if(check) {
				// 节点选中时同步选中父节点
				let parentId = data.parentId
				this.$refs.menuTree.setChecked(parentId, true, false)
			} else {
				// 节点取消选中时同步取消选中子节点
				if(data.children != null) {
					data.children.forEach(element => {
						this.$refs.menuTree.setChecked(element.id, false, false)
					});
				}
			}
		},
		// 全选操作
		handleCheckAll() {
			if(this.checkAll) {
				let allMenus = []
				this.checkAllMenu(this.menuData, allMenus)
				this.$refs.menuTree.setCheckedNodes(allMenus)
			} else {
				this.$refs.menuTree.setCheckedNodes([])
			}
		},
		// 递归全选
		checkAllMenu(menuData, allMenus) {
			menuData.forEach(menu => {
				allMenus.push(menu)
				if(menu.children) {
					this.checkAllMenu(menu.children, allMenus)
				}
			});
		},
		renderContent(h, { node, data, store }) {
			return (
			<div class="column-container">
				<span style="text-algin:center;margin-right:80px;">{data.name}</span>
				</div>);
      	}
    },
    mounted() {
         //获取树形结构，用于授权展示资源管理
         this.findResourceTree()
    }
}
</script>

<style scoped>
.menu-container {
	margin-top: 10px;
}
.menu-header {
	padding-left: 8px;
	padding-bottom: 5px;
	text-align: left;
	font-size: 16px;
	color: rgb(20, 89, 121);
}
</style>