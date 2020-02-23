<template>
  <div class="container" style="width:100%;">
    <!--工具栏-->
    <div class="toolbar" style="float:left; padding:18px;">
        <el-form :inline="true" :model="filters" size="small">
            <!--新增按钮-->
            <el-form-item>
               <kt-button label="新增" perms="sys:user:add" type="primary" @click="handleAdd" />    
            </el-form-item>
            <!--删除按钮-->
            <el-form-item>
                <kt-button label="删除" perms="sys:user:add" type="danger" @click="handleOneDelete" />
            </el-form-item>
        </el-form>
    </div>
    <!--表格内容栏-->
    <KtTable permsEdit="sys:user:edit" permsDelete="sys:user:delete"
        :data="pageResult" :columns="columns" 
        @findPage="findPage" @handleEdit="handleEdit"  @handleAuth="handleAuth" @handleDelete="handleDelete" @handleCurrentChange="handleRoleSelectChange">
    </KtTable>
    <!--新增界面-->
    <el-dialog title="注册Focus Cloud用户" width="40%" :visible.sync="addDialogVisible" :close-on-click-modal="false">
        <el-form :model="dataForm" label-width="80px" :rules="dataFormRules" ref="dataForm">
            <el-form-item label="用户名" prop="loginName">
                <el-input v-model="dataForm.loginName" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input v-model="dataForm.password" type="password" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="性别" prop="sex">
                <el-input v-model="dataForm.sex"  auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="姓名" prop="realName">
                <el-input v-model="dataForm.realName" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="昵称" prop="nickName">
                <el-input v-model="dataForm.nickName" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="电话" prop="phoneNumber">
                <el-input v-model="dataForm.phoneNumber" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="邮箱" prop="email">
                <el-input v-model="dataForm.email" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="个性签名" prop="signature">
                <el-input v-model="dataForm.signature" auto-complete="off"></el-input>
            </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click.native="addDialogVisible = false">取消</el-button>
            <el-button type="primary" @click.native="addSubmit" :loading="editLoading">提交</el-button>
        </div>
    </el-dialog>

    <!--编辑界面-->
    <el-dialog title="修改Focus Cloud用户" width="40%" :visible.sync="editDialogVisible" :close-on-click-modal="false">
        <el-form :model="dataForm" label-width="80px" :rules="dataFormRules" ref="dataForm">
            <el-form-item label="密码" prop="password">
                <el-input v-model="dataForm.password" type="password" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="性别" prop="sex">
                <el-input v-model="dataForm.sex"  auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="姓名" prop="realName">
                <el-input v-model="dataForm.realName" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="昵称" prop="nickName">
                <el-input v-model="dataForm.nickName" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="电话" prop="phoneNumber">
                <el-input v-model="dataForm.phoneNumber" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="邮箱" prop="email">
                <el-input v-model="dataForm.email" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="个性签名" prop="signature">
                <el-input v-model="dataForm.signature" auto-complete="off"></el-input>
            </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click.native="editDialogVisible = false">取消</el-button>
            <el-button type="primary" @click.native="editSubmitList" :loading="editLoading">提交</el-button>
        </div>
    </el-dialog>

    <!--授权界面-->
    <el-dialog title="用户授权" width="40%" :visible.sync="authDialogVisible" :close-on-click-modal="false">
    <!--当前页面仅用于展示资源管理菜单栏-->
    <!--资源菜单，表格树内容栏-->
	<div class="menu-container" :v-if="true">
        <el-tree :data="menuData" size="mini" show-checkbox node-key="id" :props="defaultProps"
			style="width: 100%;pading-top:20px;" ref="menuTree" :render-content="renderContent"
			v-loading="menuLoading" element-loading-text="拼命加载中" :check-strictly="true"
			@check-change="handleMenuCheckChange">
	    </el-tree>
                <div slot="footer" class="dialog-footer">
            		<kt-button label="重置" perms="sys:role:edit" type="primary" @click="resetSelection" 
				:disabled="this.selectRole.id == null"/>
			<kt-button label="授权" perms="sys:role:edit" type="primary" @click="submitAuthForm" 
				:disabled="this.selectRole.id == null" :loading="authLoading"/>
        </div>
	</div>
    </el-dialog>

 

    
  </div>
</template>

<script>
import KtTable from "@/views/Core/KtTable"
import KtButton from "@/views/Core/KtButton"
import qs from 'qs';
export default {
    components:{
            KtTable,
            KtButton
    },
    data() {
        return {
            userId: '',
            filters: {
                name: ''
            },
            columns: [
                {prop:"loginName", label:"用户名", minWidth:40, sortable:"true"},
                {prop:"nickName", label:"昵称", minWidth:40, sortable:"true"},
                {prop:"realName", label:"姓名", minWidth:40, sortable:"true"},
                {prop:"phoneNumber", label:"电话", minWidth:40, sortable:"true"},
                {prop:"signature", label:"个性签名", minWidth:40, sortable:"true"},
                {prop:"email", label:"邮箱", minWidth:40, sortable:"true"},
                {prop:"creatDate", label:"创建时间", minWidth:40, sortable:"true"}
            ],
            pageRequest: { pageNum: 1, pageSize: 8 },
            pageResult: {},
            addDialogVisible: false,  // 新增界面是否显示
            editDialogVisible: false, // 编辑界面是否显示
            authDialogVisible: false, // 授权界面是否显示
            editLoading: false,
            dataFormRules: {
                name: [
                    { required: true, message: '请输入用户名', trigger: 'blur' }
                ]
            },
            // 新增编辑界面数据
            dataForm: {
                password: 'Hydra825',
                sex: false,
                realName: 'xiaoyu',
                nickName: 'xiaoyu',
                phoneNumber: 18709214367,
                email: 'test@qq.com',
                signature: '安静只是一种表达',
            },
            deptTreeProps: {
                label: 'name',
                children: 'children'
            },
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
       // 获取分页数据
        findPage: function () {
            this.$api.user.findPage().then((res) => {
                this.pageResult = res.data
                this.pageResult.pageNum = res.data.pageNum
                this.pageResult.pageNum = res.data.pageSize
                this.pageResult.totalSize = res.data.total
                  //分页展示总数据
                this.pageResult.content = res.data.list
            })
        },
        // 删除用户
        handleOneDelete: function () {
           this.$confirm('确认删除选中记录吗？', '提示', {
            type: 'warning'
           }).then(() => {
                if(res.status == 500){
                    this.$message({ message: '删除失败', type: 'error' })
                }else if(res.status == 200){
                    this.$message({ message: '删除成功', type: 'success' })
                }
            })
        },
        // 批量删除
        handleDelete: function (data) {
            this.$api.user.batchDelete(data.params).then(data.callback)
        },
        // 显示新增界面
        handleAdd: function () {
            this.addDialogVisible = true
            this.dataForm = {
                loginName: 'xiaoyuyu',
                password: 'Hydra825',
                sex: 'false',
                realName: 'xiaoyu',
                nickName: 'xiaoyu',
                phoneNumber: 18709214367,
                email: 'test@qq.com',
                signature: '安静只是一种表达',
                imageId: 'null'
            }
        },
        // 显示编辑界面
        handleEdit: function (params) {
            this.editDialogVisible = true
            delete params.row.loginName
            this.dataForm = Object.assign({}, params.row)
        },
        // 显示授权页面
        handleAuth: function (params) {
            this.authDialogVisible = true
            this.userId = Object.assign({}, params.row)
        },
        // 用户新增按钮 提交
        addSubmit: function () {
            this.$refs.dataForm.validate((valid) => {
                if (valid) {
                    this.$confirm('确认提交吗？', '提示', {}).then(() => {
                        this.editLoading = true
                        let params = Object.assign({}, this.dataForm)
                        this.$api.user.save(qs.stringify(params)).then((res) => {
                            this.editLoading = false
                            if(res.status == 500){
                               this.$message({ message: res.data, type: 'error' })
                               return
                            }
                            this.$message({ message: '提交成功', type: 'success' })
                            this.$refs['dataForm'].resetFields()
                            this.addDialogVisible = false
                            this.findPage(null)
                        })
                    })
                }
            })
        },
        // 用户编辑按钮 提交
        editSubmitList: function () {
            this.$refs.dataForm.validate((valid) => {
                if (valid) {
                    this.$confirm('确认提交吗？', '提示', {}).then(() => {
                        this.editLoading = true
                        let params = Object.assign({}, this.dataForm)
                        this.$api.user.editUser(qs.stringify(params)).then((res) => {
                            this.editLoading = false
                            if(res.status == 500){
                               this.$message({ message: res.data, type: 'error' })
                               return
                            }
                            this.$message({ message: '提交成功', type: 'success' })
                            this.$refs['dataForm'].resetFields()
                            this.editDialogVisible = false
                            this.findPage(null)
                        })
                    })
                }
            })
        },
        // 菜单树选中
        deptTreeCurrentChangeHandle (data, node) {
            this.dataForm.deptId = data.id
            this.dataForm.deptName = data.name
        },

        // 获取资源菜单数
		findResourceTree: function () {
			this.menuLoading = true
			this.$api.user.findUserAuth({'userId':this.userId}).then((res) => {
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
			this.$api.user.findUserAuth({'userId':val.val.id}).then((res) => {
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
        // 重置选择
		resetSelection() {
			this.checkAll = false
			this.$refs.menuTree.setCheckedNodes(this.currentRoleMenus)
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
        		// 角色菜单授权提交
		submitAuthForm() {
			let userIds = this.selectRole.id
			if('admin' == this.selectRole.name) {
				this.$message({message: '超级管理员拥有所有菜单权限，不允许修改！', type: 'error'})
				return
			}
			this.authLoading = true
			let checkedNodes = this.$refs.menuTree.getCheckedNodes(false, true)
            let roleMenu = {}
			let roleMenus = []
			for(let i=0, len=checkedNodes.length; i<len; i++) {
				roleMenu = { userIds:userIds, roleIds:checkedNodes[i].id }
				roleMenus.push(roleMenu)
			}
    
			this.$api.user.saveUserAuth(qs.stringify(roleMenu)).then((res) => {
				if(res.status == 200) {
					this.$message({ message: '操作成功', type: 'success' })
                    return
				} else {
					this.$message({message: '操作失败, ' + res.data, type: 'error'})

				}
				this.authLoading = false
			})
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

</style>