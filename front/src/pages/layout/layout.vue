<template>
	<div>
		<el-container>
			<el-header>
				<Header></Header>
			</el-header>
			<el-container>
				<Aside :isCollapse="isCollapse"></Aside>
				<el-main>
					<div class="bread-crumb">
						<el-button type="primary" @click="handleChange">{{text}}</el-button>
					</div>
					<transition mode="out-in">
						<router-view></router-view>
					</transition>
				</el-main>
			</el-container>
		</el-container>
	</div>
</template>
<script>
import Aside from './components/aside'
import Header from './components/header'
export default {
	data() {
		return {
			isCollapse: false,
			text: '收起'
		}
	},
	methods: {
		handleChange() {
			this.isCollapse = !this.isCollapse
			this.text = this.isCollapse ? '展开' : '收起'
		}
	},
	components: {
		Aside,
		Header
	}
}
</script>
<style>
.bread-crumb {
	height: 40px;
	line-height: 38px;
	
}
.el-header {
	background-color: #b3c0d1;
	color: #333;
	text-align: center;
	line-height: 60px;
}

.el-main {
	background-color: #e9eef3;
	height: calc(100vh - 60px);
	padding: 0;
}
</style>
<style>
/* 路由的简单过渡动画效果 */
.v-enter {
	opacity: 0;
}
.v-enter-to {
	opacity: 1;
}
.v-enter-active {
	transition: 0.3s;
}
.v-leave {
	opacity: 1;
}
.v-leave-to {
	opacity: 0;
}
.v-leave-active {
	transition: 0.3s;
}
</style>