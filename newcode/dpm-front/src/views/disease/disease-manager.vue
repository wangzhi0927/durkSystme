<template>
  <div class="disease-content">
    <i-form inline :label-width="80">
      <i-row>
        <i-form-item prop="diseaseName" inline label="疾病名称">
          <i-input type="text" v-model="condition.diseaseName" placeholder="请输入检索疾病名称">
          </i-input>
        </i-form-item>

        <i-form-item prop="state" label="状态">
          <i-select clearable v-model="condition.state" style="width:160px" placeholder="请选择待筛选状态">
            <i-option value="1">启用</i-option>
            <i-option value="0">停用</i-option>
          </i-select>
        </i-form-item>
        <i-form-item :label-width="20">
          <i-button type="primary" @click="getDiseaseInfoList()" icon="ios-search">查询</i-button>
          <i-button type="primary" @click="showMask()"  icon="plus">新增</i-button>
        </i-form-item>
      </i-row>
      </i-form>
    <div>
      <i-table border stripe :loading="loading" :columns="diseaseInfoColumns" :data="diseaseInfoArray" class="disease_grid"></i-table>
    </div>
    <div style="margin: 10px;overflow: hidden">
      <div style="float: right;">
        <i-page :total="dataCount" :page-size="pageSize" :current.sync="currentPage" show-total
                @on-change="changePage"></i-page>
      </div>
    </div>

    <i-modal width="700px"
             :title="this.maskTitle"
             v-model="maskModal"
             :mask-closable="false"
             :closable="false" class-name="vertical-center-modal">
      <i-form ref="editFormItem" :model="editFormItem" :label-width="80" :rules="ruleValidate" >
        <i-row>
          <i-col span="12">
            <i-form-item label="疾病名称" prop="diseaseName">
              <i-input placeholder="请输入疾病名称" v-model="editFormItem.diseaseName"  style="width:180px"></i-input>
            </i-form-item>

            <i-form-item label="英文名称" prop="enName">
              <i-input placeholder="请输入英文名称" v-model="editFormItem.enName"  style="width:180px"></i-input>
            </i-form-item>
            <i-form-item label="是否启用" prop="enabled">
              <i-radio-group v-model="editFormItem.enabled">
                <i-radio label="0">不启用</i-radio>
                <i-radio label="1">启用</i-radio>
              </i-radio-group>
            </i-form-item>

            <i-form-item label="适应性别" prop="sexSign">
              <i-radio-group v-model="editFormItem.sexSign">
                <i-radio label="0">通用</i-radio>
                <i-radio label="1">男性</i-radio>
                <i-radio label="2">女性</i-radio>
              </i-radio-group>
            </i-form-item>
            <i-form-item label="拼音码" prop="pcode">
              <i-input placeholder="请输入拼音码" v-model="editFormItem.pcode"  style="width:180px"></i-input>
            </i-form-item>
            </i-col>
          <i-col span="12">
            <i-form-item label="icd10编码" prop="icd10">
              <i-input placeholder="请输入icd10编码" v-model="editFormItem.icd10"  style="width:180px"></i-input>
            </i-form-item>

            <i-form-item label="癌症标志" prop="cancerFlag">
              <i-radio-group v-model="editFormItem.cancerFlag">
                <i-radio label="0">否</i-radio>
                <i-radio label="1">是</i-radio>
              </i-radio-group>
            </i-form-item>

            <i-form-item label="关联器官" prop="organCode">
              <i-select clearable filterable v-model="editFormItem.organCode" placeholder="请选择关联器官"
                        remote
                        :remote-method="getOrganList" style="width:180px" :loading="loading">
                <i-option v-for="item in maskOrganArray" :value="item.organCode" :key="item.organCode">{{ item.organName
                  }}
                </i-option>
              </i-select>
            </i-form-item>
            <i-form-item prop="modelOperation" label="操作模式">
              <i-select v-model="editFormItem.modelOperation" style="width:180px" placeholder="请选择待操作模式">
                <i-option value="00">分片</i-option>
                <i-option value="01">移动</i-option>
                <i-option value="02">替换</i-option>
                <i-option value="03">骨折</i-option>
              </i-select>
            </i-form-item>
            <i-form-item label="五笔码" prop="fCode">
              <i-input placeholder="请输入五笔码" v-model="editFormItem.fcode"  style="width:180px"></i-input>
            </i-form-item>
          </i-col>
        </i-row>
        <i-form-item  label="描述" prop="comment">
          <i-input type="textarea" :rows="4" v-model="editFormItem.comment" placeholder="请输入描述信息" style="width:520px" >
          </i-input>
        </i-form-item>
        
         <i-form-item v-show="!!diseaseRelResList&&diseaseRelResList.length>0" label="资源信息">
        	<i-row>
	        	<i-col span="3">所属平台</i-col>
	        	<i-col span="8">资源名称</i-col>
	        	<i-col span="3">操作</i-col>
	        </i-row>
	        <i-row v-for="(item,index) in diseaseRelResList">
	        	<i-col span="3">{{getLabelByPlatform(item.platform)}}</i-col>
	        	<i-col span="8">{{item.resourceInfo.resoName}}</i-col>
	        	<i-col span="3"><i-button type="ghost" @click="deleteInfo(index)">删除</i-button></i-col>
	        </i-row>
        </i-form-item>
      </i-form>
      <div slot="footer">
      	<i-button type="success" size="large" @click="showResMask">绑定资源信息</i-button>
        <i-button type="primary" size="large" @click="saveDiseaseInfo" v-show="editFormItem.operatorType!=='2'">保存</i-button>
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
              <i-select v-model="editFormResItem.platform" style="width:260px" placeholder="请选择平台">
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
                        :remote-method="getResList" style="width:260px" :loading="loading">
                <i-option v-for="item in maskRelModelArray" :value="item" :key="item.id">{{ item.resoName
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
    
    <i-modal width="800px"
             :title="this.maskCaseTitle"
             v-model="maskCaseModal"
             :mask-closable="false"
             :closable="false" class-name="vertical-center-modal">
      <i-form ref="editFormCaseItem" :model="editFormCaseItem" :label-width="200">
        <template>		
				<Transfer
		        :data="caseInfoArray"
		        :target-keys="diseaseCaseArray"
		        filterable
		        @on-change="caseChange">
		        </Transfer>		    
		</template>
      </i-form>
      <div slot="footer">
        <i-button type="primary" size="large" @click="saveRelCase">保存</i-button>
        <i-button type="ghost" @click="closeCase" size="large">关闭</i-button>
      </div>
    </i-modal>
  </div>
</template>

<script>
  import Cookies from 'js-cookie'

  export default {
    name: 'disease-manager',
    data () {
      return {
        condition: {
          diseaseName: '',//过滤疾病名称名称
          state:''//状态
        },
        maskOrganArray: [],//资源器官数据
        diseaseInfoArray: [],//用户信息数据
        maskRelModelArray:[],//资源数据
        diseaseRelResList: [],
        caseInfoArray: [],
        diseaseCaseArray: [],
        currentPage: 1,
        loading:false,
        emptyMask: {
          id: '',
          diseaseName:'',
          icd10:'',
          cancerFlag:'',
          enName:'',
          comment:'',
          enabled:'',
          organCode:'',
          sexSign:'',
          modelOperation:'',
          pCode:'',
          fCode:'',
          operatorType:'0'
        },
        
        
        headers: {
          token: Cookies.get('token')
        },
        maskTitle: '疾病信息维护',
        maskResTitle: '绑定资源数据',
        maskCaseTitle: '方案管理',
        editFormItem: {},
        editFormResItem: {},
        editFormCaseItem: {},
        diseaseId:'',
        maskModal: false,
        maskResModal: false,
        maskCaseModal: false,
        // 初始化信息总条数
        dataCount: 0,
        // 每页显示多少条
        pageSize: 13,
        diseaseInfoColumns: [
          {
            title: '疾病名称',
            key: 'diseaseName'
          },
          {
            title: '英文名称',
            key: 'enName',
          },
          {
            title: 'ICD10标准码',
            key: 'icd10'
          },
          {
            title: '所属器官',
            key: 'organCode'
          },
          {
            title: '适应性别',
            key: 'sexSign',
            render: (h, params) => {
              return h('div', [
                h('strong', this.getLabelBySexSign(params.row.sexSign))
              ]);
            }
          },
          {
            title: '状态',
            key: 'enabled',
            render: (h, params) => {
              return h('div', [
                h('strong', this.getLabelByStateCode(params.row.enabled))
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
                      this.showMask(params.row)
                    }
                  }
                }, '查看'),h('i-button', {
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
                      params.row.operatorType = '3'
                      this.showCaseMask(params.row)
                    }
                  }
                }, '方案管理')
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
          diseaseName: [
            { required: true, message: 'The diseaseName cannot be empty', trigger: 'blur' }
          ],
          enabled: [
            { required: true, message: 'Please select enabled', trigger: 'change' }
          ],
          sexSign: [
            { required: true, message: 'Please select sexSign', trigger: 'change' }
          ],
          cancerFlag: [
            { required: true, message: 'Please select cancerFlag', trigger: 'change' }
          ],
          modelOperation: [
            { required: true, message: 'Please select the modelOperation', trigger: 'change' }
          ],
          pcode: [
            { required: true, message: 'The pCode cannot be empty', trigger: 'blur' }
          ]
        }
      }
    },

    methods: {
      getLabelByStateCode(code){
       let label = ''
        switch (code){
          case '0':
            label='已停用'
            break
          case '1':
            label='已启用'
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
      getLabelBySexSign(sign){
        let label = ''
        switch (sign){
          case '0':
            label='通用'
            break
          case '1':
            label='男性'
            break
          case '2':
            label='女性'
            break
          default:
        }
        return label
      },
      
      // 获取历史记录信息
      changePage (index) {
        this.getDiseaseInfoList(index)
      },
      //弹出用户辑窗口
      showMask (rows) {
        this.editFormItem = JSON.parse(JSON.stringify(this.emptyMask))
        if (!!rows) {
          let dataRow = JSON.parse(JSON.stringify(rows))
          this.getDiseaseRelation(dataRow).then(function (res) {
            this.editFormItem = dataRow
          }.bind(this))
        }
        this.maskModal = true
      },

  	  //弹出资源绑定窗口
      showResMask () {
      	//this.editFormResItem = JSON.parse(JSON.stringify(this.emptyResMask))
        this.maskResModal = true
      },
      
      //弹出资源绑定窗口
      showCaseMask (rows) {
        if (!!rows) {
          this.diseaseId = rows.id;
          let dataRow = JSON.parse(JSON.stringify(rows))
          this.getDiseaseCaseRelation(dataRow).then(function (res) {
            this.editFormCaseItem = dataRow
          }.bind(this))
        }
        this.maskCaseModal = true
      },
      
      deleteInfo(index){
         this.diseaseRelResList.splice(index,1);
      },
      
      //获取器官数据
      getOrganList (query) {
        if (query !== '') {
          this.loading = true;
          this.$axios.ajax({
            method: 'get',
            url: '/model/getOrganList?key=' + query,
            data: {}
          }).then((res) => {
            this.loading = false;
            if (!!res.data.code && 10000 == res.data.code) {
              this.maskOrganArray = JSON.parse(JSON.stringify(res.data.data))
            } else {
              this.$Message.error(!!res.data && !!res.data.msg ? res.data.msg : '获取器官信息失败')
            }
          })
        }
      },
      //获取器官数据
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
      //获取案件数据
      getDiseaseCaseRelation (item) {
      	return new Promise(function (resolve, reject) {
	      this.$axios.ajax({
	        method: 'post',
	        url: '/disease/getDiseaseCaseRelation',
	        data: item
	      }).then((res) => {
	        this.loading = false;
	        if (!!res.data.code && 10000 == res.data.code) {
	          let data = res.data.data;
	          let caseData = !!data['caseInfoList']?data['caseInfoList']:[];
	          let diseaseRelData = !!data['diseaseRelCaseList']?data['diseaseRelCaseList']:[];
	          let tmpArray = [];
	          let tmpArray1 = [];
	          for(let i=0;i<caseData.length;i++){
	          	let obj = {};
	          	obj.key = caseData[i].id;
	          	obj.label = caseData[i].caseName;
	          	tmpArray.push(obj);
	          }
	          for(let i=0;i<diseaseRelData.length;i++){
	          	tmpArray1.push(diseaseRelData[i].caseId);
	          }
	          this.caseInfoArray = tmpArray;
	          this.diseaseCaseArray = tmpArray1;
	        } else {
	          this.$Message.error(!!res.data && !!res.data.msg ? res.data.msg : '获取案件信息失败')
	        }
	      })
	     }.bind(this))
      },
      
      caseChange (newTargetKeys) {
          this.diseaseCaseArray = newTargetKeys;
      },
            
      getDiseaseRelation (item) {
        return new Promise(function (resolve, reject) {
          this.$axios.ajax({
            method: 'post',
            url: '/disease/getDiseaseRelation',
            data: item
          }).then((res) => {
            if (!!res.data.code && 10000 == res.data.code) {
              let data = res.data.data
              this.maskOrganArray = !!data['organInfoList']?data['organInfoList']:[]
              this.diseaseRelResList = !!data['diseaseRelResList']?data['diseaseRelResList']:[]
            } else {
              this.$Message.error(!!res.data && !!res.data.msg ? res.data.msg : '获取数据失败')
            }
            resolve(res)
          })
        }.bind(this))
      },
      //获取疾病信息
      getDiseaseInfoList (pageIndex) {
        this.diseaseInfoArray = []
        if (isNaN(pageIndex)) {
          this.currentPage = 1
        }
        this.$axios.ajax({
          method: 'post',
          url: '/disease/getDiseaseInfoByCondition',
          data: {
            'pageNum': !isNaN(pageIndex) ? pageIndex : 1,
            'pageSize': this.pageSize,
            'diseaseInfo': {
              'diseaseName': this.condition.diseaseName,
              'enabled': this.condition.state
            }
          }
        }).then((res) => {
          if (!!res.data.code && 10000 == res.data.code) {
            let data = res.data.data
            this.dataCount = !!data['total'] ? data['total'] : 0
            this.diseaseInfoArray = !!data['list'] ? data['list'] : []
          } else {
            this.$Message.error(!!res.data && !!res.data.message ? res.data.message : '获取科室列表数据失败')
          }
        })
      },
      closeModal () {
        this.maskModal = false
        this.diseaseRelResList = [];
      },
      closeRes() {
        this.maskResModal = false
      },
      closeCase() {
        this.maskCaseModal = false
      },
      //保存疾病信息
      saveDiseaseInfo () {
        this.$refs['editFormItem'].validate((valid) => {
          if (valid) {
            this.$axios.ajax({
              method: 'post',
              url: '/disease/saveOrUpdateDiseaseInfo',
              data: {'diseaseInfo':this.editFormItem,'diseaseRelResList':this.diseaseRelResList}
            }).then((res) => {
              if (!!res.data.code && 10000 == res.data.code) {
                this.$Message.success('保存疾病信息成功')
                this.getDiseaseInfoList()
                this.maskModal = false
              } else {
                this.$Message.error(!!res.data && !!res.data.msg ? res.data.msg : '保存疾病信息失败')
              }
            })
          }
        })
      },
      
       //保存疾病信息
      saveRelCase () {
      	if(this.diseaseCaseArray == ''){
      		this.$Message.error('方案信息不能为空');
      		return;
      	}
        this.$axios.ajax({
          method: 'post',
          url: '/disease/saveDiseaseRelCase',
          data: {'diseaseInfo':{'id':this.diseaseId},'relCaseArray':this.diseaseCaseArray}
        }).then((res) => {
          if (!!res.data.code && 10000 == res.data.code) {
            this.$Message.success('保存方案信息成功')
            this.getDiseaseInfoList()
            this.maskCaseModal = false
          } else {
            this.$Message.error(!!res.data && !!res.data.msg ? res.data.msg : '保存方案信息失败')
          }
        })
      },
      
      saveResParam () {
          this.$refs['editFormResItem'].validate((valid) => {
          if (valid) {
		      var obj={};
		      obj.platform = this.editFormResItem.platform;
		      obj.resId = this.editFormResItem.item.id;
		      var resObj = {};
		      resObj.resoName = this.editFormResItem.item.resoName;
		      obj.resourceInfo = resObj;
		      this.diseaseRelResList.push(obj);
		      this.maskResModal = false;
			}		  
		  })
      },
      
      changeState(rows) {
        this.$Modal.confirm({
          title: '确认信息',
          content: '<p>确认修改当前状态？</p>',
          onOk: () => {
            let diseaseData = JSON.parse(JSON.stringify(rows))
            this.$axios.ajax({
              method: 'post',
              url: '/disease/changDiseaseStateById',
              data: diseaseData
            }).then((res) => {
              if (!!res.data.code && 10000 == res.data.code) {
                this.$Message.success('状态更改成功')
                this.getDiseaseInfoList()
              } else {
                this.$Message.error(!!res.data && !!res.data.msg ? res.data.msg : '状态更改失败')
              }
            })
          },
          onCancel: () => {
            return;
          }
        })
      }
    },
    created () {
      this.getDiseaseInfoList()//获取疾病信息列表
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
   .ivu-transfer-list {
    display: inline-block;
    width: 255px;
    height: 350px;
    font-size: 12px;
    vertical-align: middle;
    position: relative;
    padding-top: 35px;
}
</style>
