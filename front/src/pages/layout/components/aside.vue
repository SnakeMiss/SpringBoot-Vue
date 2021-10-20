<template>
	<div>
		<el-menu class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse">
			<el-menu-item index="1" @click="handleClick({name:'homePage'})">
				<i class="el-icon-menu"></i>
				<span slot="title">首页</span>
			</el-menu-item>
			<el-submenu index="2">
				<template slot="title">
					<i class="el-icon-location"></i>
					<span>导航一</span>
				</template>
				<el-menu-item-group>				
					<el-menu-item index="2-3" @click="handleClick({name:'list'})">Demo管理</el-menu-item>
				</el-menu-item-group>
			</el-submenu>
		</el-menu>
	</div>
</template>
<script>
export default {
	data() {
		return {
		}
	},
	props: {
		isCollapse: {
			default: true
		}
	},
	methods: {
		handleClick(name) {
			this.$router.push(name)
		},
		handleOpen(key, keyPath) {
			console.log(key, keyPath);
		},
		handleClose(key, keyPath) {
			console.log(key, keyPath);
		}
	}
}
</script>
<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
	width: 200px;
	min-height: 400px;
}
</style>