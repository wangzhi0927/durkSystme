<template>
  <div class="disease-content">
    <i-form inline :label-width="80">
      <i-row>
        <i-form-item prop="caseName" inline label="方案名称">
          <i-input type="text" v-model="condition.caseName" placeholder="请输入检索器官名称">
          </i-input>
        </i-form-item>
        <i-form-item prop="type" label="类型">
          <i-select clearable v-model="condition.type" style="width:160px" placeholder="请选择待筛选类型">
            <i-option value="1">手术/治疗</i-option>
            <i-option value="2">风险及并发症</i-option>
            <i-option value="3">其它</i-option>
          </i-select>
        </i-form-item>
        <i-form-item :label-width="20">
          <i-button type="primary" @click="getCaseInfoList()" icon="ios-search">查询</i-button>
          <i-button type="primary" @click="showMask()"  icon="plus">新增</i-button>
        </i-form-item>
      </i-row>
      </i-form>
    <div>
      <i-table border stripe :loading="false" :columns="caseInfoColumns" :data="caseInfoArray" class="disease_grid"></i-table>
    </div>
    <div style="margin: 10px;overflow: hidden">
      <div style="float: right;">
        <i-page :total="dataCount" :page-size="pageSize" :current.sync="currentPage" show-total
                @on-change="changePage"></i-page>
      </div>
    </div>

    <i-modal width="900px"
             :title="this.maskTitle"
             v-model="maskModal"
             :mask-closable="false"
             :closable="false" class-name="vertical-center-modal">
      <i-form ref="editFormItem" :model="editFormItem" :label-width="80" :rules="ruleValidate" >
        <i-row>
          <i-col span="8">
            <i-form-item label="手术方案" prop="caseName">
              <i-input placeholder="请输入手术方案名称" v-model="editFormItem.caseName"></i-input>
            </i-form-item>
          </i-col>
          <i-col span="8">
			<i-form-item label="类型" prop="type">
              <i-select v-model="editFormItem.type" placeholder="请选择类型">
                <i-option value="1">手术/治疗</i-option>
	            <i-option value="2">风险及并发症</i-option>
	            <i-option value="3">其它</i-option>
              </i-select>
            </i-form-item>
          </i-col>
          <i-col span="8">
            <i-form-item label="副标题" prop="subhead">
              <i-input placeholder="请输入副标题" v-model="editFormItem.subhead"  style="width:180px"></i-input>
            </i-form-item>
          </i-col>
        </i-row>
        <!--<i-row>
          <i-col span="12">
            <i-form-item label="拼音简码" prop="pCode">
              <i-input placeholder="请输入拼音简码" v-model="editFormItem.pCode" style="width:180px"></i-input>
            </i-form-item>
          </i-col>
          <i-col span="12">
            <i-form-item label="五笔简码" prop="fCode">
              <i-input placeholder="请输入五笔简码" v-model="editFormItem.fCode" style="width:180px"></i-input>
            </i-form-item>
          </i-col>
        </i-row>-->
        <i-row>
          <i-col span="24">
          	<i-form-item label="内容" prop="content">
              <i-input placeholder="请输入内容" v-model="editFormItem.content" type="textarea" :autosize="{minRows:3,maxRows: 5}"></i-input>
            </i-form-item>
          </i-col>
        </i-row>
        <i-row>
          <i-col span="24">
          	<i-form-item label="手术概况" prop="icfDisease">
              <i-input placeholder="请输入手术概况" v-model="editFormItem.icfDisease" type="textarea" :autosize="{minRows: 3,maxRows: 5}"></i-input>
            </i-form-item>
          </i-col>
        </i-row>
        <i-row>
          <i-col span="24">
          	<i-form-item label="潜在风险" prop="icfCure">
              <i-input placeholder="请输入潜在风险" v-model="editFormItem.icfCure" type="textarea" :autosize="{minRows: 3,maxRows: 5}"></i-input>
            </i-form-item>
          </i-col>
        </i-row>
        <i-row>
          <i-col span="24">
          	<i-form-item label="知情选择" prop="icfPatient">
              <i-input placeholder="请输入知情选择" v-model="editFormItem.icfPatient" type="textarea" :autosize="{minRows: 3,maxRows: 5}"></i-input>
            </i-form-item>
          </i-col>
        </i-row>
        
         <i-form-item v-show="!!caseRelResList&&caseRelResList.length>0" label="资源信息">
        	<i-row>
	        	<i-col span="3">所属平台</i-col>
	        	<i-col span="8">资源名称</i-col>
	        	<i-col span="3">操作</i-col>
	        </i-row>
	        <i-row v-for="(item,index) in caseRelResList">
	        	<i-col span="3">{{getLabelByPlatform(item.platform)}}</i-col>
	        	<i-col span="8">{{item.resourceInfo.resoName}}</i-col>
	        	<i-col span="3"><i-button type="ghost" @click="deleteInfo(index)">删除</i-button></i-col>
	        </i-row>
        </i-form-item>
      </i-form>
      <div slot="footer">
      	<i-button type="success" size="large" @click="showResMask">绑定资源信息</i-button>
        <i-button type="primary" size="large" @click="saveCaseInfo">保存</i-button>
        <i-button type="ghost" @click="closeModal" size="large">关闭</i-button>
      </div>
    </i-modal>
    
     <i-modal width="800px"
             :title="this.maskResTitle"
             v-model="maskResModal"
             :mask-closable="false"
             :closable="false" class-name="vertical-center-modal">
      <i-form ref="editFormResItem" :model="editFormResItem" :label-width="80" :rules="ruleValidate">
         <i-row>
          <i-col span="12">
            <i-form-item prop="platform" label="绑定资源所属平台">
              <i-select v-model="editFormResItem.platform" style="width:180px" placeholder="请选择平台">
                <i-option value="1">windows</i-option>
                <i-option value="2">android</i-option>
                <i-option value="3">ios</i-option>
              </i-select>
            </i-form-item>
          </i-col>
          <i-col span="12">
            <i-form-item prop="resId" label="绑定资源">
              <i-select clearable filterable v-model="editFormResItem.item" placeholder="请选择绑定资源"
                        remote
                        :remote-method="getResList" style="width:180px" :loading="loading">
                <i-option v-for="item in maskRelModelArray" v-bind:value="item" :key="item.id">{{ item.resoName
                  }}
                </i-option>
              </i-select>
            </i-form-item>
          </i-col>
         </i-row> 
      </i-form>
      <div slot="footer">
        <i-button type="primary" size="large" @click="saveResParam">保存</i-button>
        <i-button type="ghost" @click="closeRes" size="large">关闭</i-button>
      </div>
    </i-modal>
  </div>
</template>

<script>
  import Cookies from 'js-cookie'
  
  const object2String = obj => {
	  return JSON.parse(obj)
	}

  export default {
    name: 'case-manage',
    filters: {
	    object2String
	  },
    data () {
      return {
        condition: {
          caseName: '',//过滤疾病名称名称
          type:''//状态
        },
        caseRelResList: [],//资源器官数据
        caseInfoArray: [],//器官信息数据
        maskSysArray:[],
        maskRelModelArray:[],
        currentPage: 1,
        loading:false,
        emptyMask: {
          id: '',
          caseName:'',
          type:'',
          content:'',
          icfDisease:'',
          icfCure:'',
          icfPatient:'',
          operatorType:'0'
        },
        headers: {
          token: Cookies.get('token')
        },
        maskTitle: '手术方案维护',
        maskResTitle: '绑定资源数据',
        editFormItem: {},
        editFormResItem: {},
        maskModal: false,
        maskResModal: false,
        // 初始化信息总条数
        dataCount: 0,
        // 每页显示多少条
        pageSize: 13,
        caseInfoColumns: [
          {
            title: '手术方案名称',
            key: 'caseName'
          },
          {
            title: '类型',
            key: 'type',
            render: (h, params) => {
              return h('div', [
                h('strong', this.getLabelByType(params.row.type))
              ]);
            }
          },
          {
            title: '内容',
            key: 'content',
            render: (h, params) => {
			      return h('div', [
			         h('span', {
			             style: {
			                 display: 'inline-block',
			                 width: '100%',
			                 overflow: 'hidden',
			                 textOverflow: 'ellipsis',
			                 whiteSpace: 'nowrap'
			             },
			             domProps: {
			                 title: params.row.content
			             }
			         }, params.row.content)
			     ]);
			 }
          },
          {
            title: '手术概况',
            key: 'icfDisease',
            render: (h, params) => {
			      return h('div', [
			         h('span', {
			             style: {
			                 display: 'inline-block',
			                 width: '100%',
			                 overflow: 'hidden',
			                 textOverflow: 'ellipsis',
			                 whiteSpace: 'nowrap'
			             },
			             domProps: {
			                 title: params.row.icfDisease
			             }
			         }, params.row.icfDisease)
			     ]);
			 }
          },
          {
            title: '潜在风险',
            key: 'icfCure',
            render: (h, params) => {
			      return h('div', [
			         h('span', {
			             style: {
			                 display: 'inline-block',
			                 width: '100%',
			                 overflow: 'hidden',
			                 textOverflow: 'ellipsis',
			                 whiteSpace: 'nowrap'
			             },
			             domProps: {
			                 title: params.row.icfCure
			             }
			         }, params.row.icfCure)
			     ]);
			 }
          },
          {
            title: '知情选择',
            key: 'icfPatient',
            render: (h, params) => {
			      return h('div', [
			         h('span', {
			             style: {
			                 display: 'inline-block',
			                 width: '100%',
			                 overflow: 'hidden',
			                 textOverflow: 'ellipsis',
			                 whiteSpace: 'nowrap'
			             },
			             domProps: {
			                 title: params.row.icfPatient
			             }
			         }, params.row.icfPatient)
			     ]);
			 }
          },
          {
            title: '操作',
            key: 'action',
            width: 360,
            align: 'center',
            render: (h, params) => {
              let btns = []
              btns.push(
                h('i-button', {
                  props: {
                    type: 'primary',
                    size: 'small',
                    icon:'edit'
                  },
                  style: {
                    marginRight: '5px'
                  },
                  on: {
                    click: () => {
                      params.row.operatorType = '1'
                      this.showMask(params.row)
                    }
                  }
                }, '编辑'),h('i-button', {
                  props: {
                    type: 'primary',
                    size: 'small',
                    icon:'eye'
                  },
                  style: {
                    marginRight: '5px'
                  },
                  on: {
                    click: () => {
                      params.row.operatorType = '2'
                      this.delCaseInfo(params.row)
                    }
                  }
                }, '删除')
              )
              params.row.enabled==='1' && btns.push(
                h('i-button', {
                  props: {
                    type: 'primary',
                    size: 'small',
                    icon:'ios-close-outline'
                  },
                  style: {
                    marginRight: '5px'
                  },
                  on: {
                    click: () => {
                      this.changeState(params.row)
                    }
                  }
                }, '停用')
              )
              params.row.enabled==='0' && btns.push(
                h('i-button', {
                  props: {
                    type: 'warning',
                    size: 'small',
                    icon:'ios-checkmark-outline'
                  },
                  style: {
                    marginRight: '5px'
                  },
                  on: {
                    click: () => {
                      this.changeState(params.row)
                    }
                  }
                }, '启用')
              )
              return h("div",btns)
            }
          }
        ],
        ruleValidate: {
          organName: [
            { required: true, message: '器官名称不能为空', trigger: 'blur' }
          ],
          belongId: [
            { required: true, message: '请选择所属系统', trigger: 'blur' }
          ],
          typeDefault: [
            { required: true, message: '请选择适用用性别', trigger: 'blur' }
          ],
          modelOperation: [
            { required: true, message: 'Please select the modelOperation', trigger: 'blur' }
          ]
        }
      }
    },

    methods: {
      getLabelByContent(sign){
        let label = sign;
        if(sign.length>12){
          label = sign.substring(0,12) + "...";
        }
        return label;
      },
      getLabelByType(type){
        let label = ''
        switch (type){
          case '1':
            label='手术/治疗'
            break
          case '2':
            label='风险及并发症'
            break
          case '3':
            label='其它'
            break
          default:
        }
        return label
      },
       getLabelByPlatform(code){
       let label = ''
        switch (code){
          case '1':
            label='windows'
            break
          case '2':
            label='android'
            break
          case '3':
            label='ios'
            break
          default:
        }
        return label
      },
      // 获取历史记录信息
      changePage (index) {
        this.getCaseInfoList(index)
      },
      //弹出用户辑窗口
      showMask (rows) {
        this.editFormItem = JSON.parse(JSON.stringify(this.emptyMask));
        if (!!rows) {
          	let dataRow = JSON.parse(JSON.stringify(rows))
	        this.getCaseRelation(dataRow).then(function (res) {
	            this.editFormItem = dataRow;
	          }.bind(this))
         }
        this.maskModal = true
      },

      //弹出资源绑定窗口
      showResMask () {
        this.maskResModal = true
      },
      deleteInfo(index){
         this.caseRelResList.splice(index,1);
      },
      saveResParam () {
	      var obj={};
	      obj.platform = this.editFormResItem.platform;
	      obj.resId = this.editFormResItem.item.id;
	      var resObj = {};
	      resObj.resoName = this.editFormResItem.item.resoName;
	      obj.resourceInfo = resObj;
	      this.caseRelResList.push(obj);
	      this.maskResModal = false;
      },
      //获取资源数据
      getResList (query) {
        if (query !== '') {
          this.loading = true;
          this.$axios.ajax({
            method: 'get',
            url: '/disease/getResList?key=' + query,
            data: {}
          }).then((res) => {
            this.loading = false;
            if (!!res.data.code && 10000 == res.data.code) {
              this.maskRelModelArray = JSON.parse(JSON.stringify(res.data.data))
            } else {
              this.$Message.error(!!res.data && !!res.data.msg ? res.data.msg : '获取器官信息失败')
            }
          })
        }
      },
      //获取方案信息
      getCaseInfoList (pageIndex) {
        this.caseInfoArray = []
        if (isNaN(pageIndex)) {
          this.currentPage = 1
        }
        this.$axios.ajax({
          method: 'post',
          url: '/case/getCaseInfoByCondition',
          data: {
            'pageNum': !isNaN(pageIndex) ? pageIndex : 1,
            'pageSize': this.pageSize,
            'caseInfo': {
              'caseName': this.condition.caseName,
              'type': this.condition.type
            }
          }
        }).then((res) => {
          if (!!res.data.code && 10000 == res.data.code) {
            let data = res.data.data
            this.dataCount = !!data['total'] ? data['total'] : 0
            this.caseInfoArray = !!data['list'] ? data['list'] : []
          } else {
            this.$Message.error(!!res.data && !!res.data.message ? res.data.message : '获取科室列表数据失败')
          }
        })
      },
      closeModal () {
        this.maskModal = false
      },
      closeRes() {
        this.maskResModal = false
      },
       //删除器官信息
	   delCaseInfo(rows) {
	       this.$Modal.confirm({
	          title: '确认信息',
	          content: '<p1>确认删除该数据？</p1>',
	          onOk: () => {
	            let organData = JSON.parse(JSON.stringify(rows))
	            this.$axios.ajax({
	              method: 'post',
	              url: '/case/delCaseInfo',
	              data: organData
	            }).then((res) => {
	              if (!!res.data.code && 10000 == res.data.code) {
	                this.$Message.success('删除成功')
	                this.getCaseInfoList()
	              } else {
	                this.$Message.error(!!res.data && !!res.data.msg ? res.data.msg : '删除失败')
	              }
	            })
	          },
	          onCancel: () => {
	            return;
	          }
	        })
	    },
	    
      //保存手术方案信息
      saveCaseInfo () {
        this.$refs['editFormItem'].validate((valid) => {
          if (valid) {
            this.$axios.ajax({
              method: 'post',
              url: '/case/saveOrUpdateCaseInfo',
              data: {'caseInfo':this.editFormItem,'caseRelResList':this.caseRelResList}
            }).then((res) => {
              if (!!res.data.code && 10000 == res.data.code) {
                this.$Message.success('保存手术方案成功')
                this.getCaseInfoList()
                this.maskModal = false
              } else {
                this.$Message.error(!!res.data && !!res.data.msg ? res.data.msg : '保存手术方案失败')
              }
            })
          }
        })
      },
      getCaseRelation (item) {
        return new Promise(function (resolve, reject) {
          this.$axios.ajax({
            method: 'post',
            url: '/case/getCaseInfoRelation',
            data: item
          }).then((res) => {
            if (!!res.data.code && 10000 == res.data.code) {
              let data = res.data.data
              this.caseRelResList = !!data['caseRelResList']?data['caseRelResList']:[]
            } else {
              this.$Message.error(!!res.data && !!res.data.msg ? res.data.msg : '获取数据失败')
            }
            resolve(res)
          })
        }.bind(this))
      },
    },
    created () {
      this.getCaseInfoList()//获取器官信息列表
    }
  }
</script>

<style>
  .disease-content {
    width: 100%;
    height: 100%;
  }

  .disease_grid {
    height: calc(100vh - 300px);
    overflow: auto;
  }

  .vertical-center-modal {
    display: flex;
    align-items: center;
    justify-content: center;
  }

  .vertical-center-modal .ivu-modal {
    top: 0;
  }
</style>
