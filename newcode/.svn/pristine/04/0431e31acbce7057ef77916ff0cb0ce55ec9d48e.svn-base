<template>
  <div class="disease-content">
    <i-form inline :label-width="80">
      <i-row>
        <i-form-item prop="organName" inline label="器官名称">
          <i-input type="text" v-model="condition.organName" placeholder="请输入检索器官名称">
          </i-input>
        </i-form-item>

        <i-form-item prop="organCode" inline label="器官编码">
          <i-input type="text" v-model="condition.organCode" placeholder="请输入检索器官编码">
          </i-input>
        </i-form-item>
        <i-form-item :label-width="20">
          <i-button type="primary" @click="getOrganInfoList()" icon="ios-search">查询</i-button>
          <i-button type="primary" @click="showMask()"  icon="plus">新增</i-button>
        </i-form-item>
      </i-row>
      </i-form>
    <div>
      <i-table border stripe :loading="false" :columns="organInfoColumns" :data="organInfoArray" class="disease_grid"></i-table>
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
            <i-form-item label="器官名称" prop="organName">
              <i-input placeholder="请输入器官名称" v-model="editFormItem.organName"  style="width:180px"></i-input>
            </i-form-item>
          </i-col>
          <i-col span="9">
			<i-form-item label="所属系统" prop="belongId" filterable clearable>
              <i-select v-model="editFormItem.belongId" placeholder="请选择所属系统">
               <i-option v-for="(value,key) in maskSysArray" :value="key" key="value">{{value}}
                </i-option>
              </i-select>
            </i-form-item>
          </i-col>
        </i-row>
        <i-row>
          <i-col span="12">
          	<i-form-item label="器官编码" prop="organCode">
              <i-input placeholder="请输入器官编码" v-model="editFormItem.organCode"  style="width:180px"></i-input>
            </i-form-item>
          </i-col>
          <i-col span="9">
            <i-form-item label="适用性别" prop="typeDefault">
              <i-select v-model="editFormItem.typeDefault" placeholder="请选择所属性别">
                <i-option value="0">通用</i-option>
                <i-option value="1">男</i-option>
                <i-option value="2">女</i-option>
              </i-select>
            </i-form-item>
          </i-col>
        </i-row>
        <i-row>
          <i-col span="12">
          	<i-form-item label="图标名称" prop="iconName">
              <i-input placeholder="请输入图标名称" v-model="editFormItem.iconName"  style="width:180px"></i-input>
            </i-form-item>
          </i-col>
          <i-col span="9">
            <i-form-item label="器官类型" prop="organType">
              <i-select v-model="editFormItem.organType" placeholder="请选择器官类型">
                <i-option value="01">腔道</i-option>
                <i-option value="02">实体</i-option>
                <i-option value="03">主动脉</i-option>
                <i-option value="04">骨骼</i-option>
              </i-select>
            </i-form-item>
          </i-col>
        </i-row>
        <i-row>
         <i-col span="12">
            <i-form-item label="关联模型" prop="relResId">
            	<i-input placeholder="请输入关联显示模型" v-model="editFormItem.relResId"  style="width:180px"></i-input>
            </i-form-item>
          </i-col>
       	   <i-col span="9">
        	<i-form-item label="模型资源" prop="resId">
             	<i-select v-model="editFormItem.resId" placeholder="请选择模型资源">
                	<i-option v-for="(item,index) in maskRelModelArray" :value="item.id" key="item">{{item.resoName }}
                	</i-option>
                </i-select>
            </i-form-item>
          </i-col>  
        </i-row>
      </i-form>
      <div slot="footer">
        <i-button type="primary" size="large" @click="saveOrganInfo">保存</i-button>
        <i-button type="ghost" @click="closeModal" size="large">关闭</i-button>
      </div>
    </i-modal>
  </div>
</template>

<script>
  import Cookies from 'js-cookie'

  export default {
    name: 'organ-manager',
    data () {
      return {
        condition: {
          organName: '',//过滤疾病名称名称
          organCode:''//状态
        },
        maskOrganArray: [],//资源器官数据
        organInfoArray: [],//器官信息数据
        maskSysArray:[],
        maskRelModelArray:[],
        relModelArray:[],
        currentPage: 1,
        loading:false,
        emptyMask: {
          id: '',
          organName:'',
          organCode:'',
          belongName:'',
          belongId:'',
          typeDefault:'',
          iconName:'',
          operatorType:'0'
        },
        headers: {
          token: Cookies.get('token')
        },
        maskTitle: '器官信息维护',
        editFormItem: {},
        maskModal: false,
        // 初始化信息总条数
        dataCount: 0,
        // 每页显示多少条
        pageSize: 13,
        organInfoColumns: [
          {
            title: '器官名称',
            key: 'organName'
          },
          {
            title: '器官编码',
            key: 'organCode',
          },
          {
            title: '所属系统',
            key: 'belongName'
          },
          {
            title: '所属系统id',
            key: 'belongId'
          },
          {
            title: '资源id',
            key: 'resId'
          },
          {
            title: '适用性别',
            key: 'typeDefault',
            render: (h, params) => {
              return h('div', [
                h('strong', this.getLabelBySexSign(params.row.typeDefault))
              ]);
            }
          },
          {
            title: '展示图标名称',
            key: 'iconName'
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
                      this.delOrganInfo(params.row)
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
        this.getOrganInfoList(index)
      },
      //弹出用户辑窗口
      showMask (rows) {
        this.editFormItem = JSON.parse(JSON.stringify(this.emptyMask));
        if (!!rows) {
          	let dataRow = JSON.parse(JSON.stringify(rows))
	        this.getOrganRelation(dataRow).then(function (res) {
	            this.editFormItem = dataRow;
	          }.bind(this))
         }
        this.maskModal = true
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
      getOrganRelation (item) {
        return new Promise(function (resolve, reject) {
          this.$axios.ajax({
            method: 'post',
            url: '/organ/getOrganRelation',
            data: {}
          }).then((res) => {
            if (!!res.data.code && 10000 == res.data.code) {
              this.maskSysArray = res.data.data['sysInfo'];
              this.maskRelModelArray = res.data.data['relModelList'];
            } else {
              this.$Message.error(!!res.data && !!res.data.msg ? res.data.msg : '获取数据失败')
            }
            resolve(res)
          })
        }.bind(this))
      },
      //获取器官信息
      getOrganInfoList (pageIndex) {
        this.organInfoArray = []
        if (isNaN(pageIndex)) {
          this.currentPage = 1
        }
        this.$axios.ajax({
          method: 'post',
          url: '/organ/getOrganInfoByCondition',
          data: {
            'pageNum': !isNaN(pageIndex) ? pageIndex : 1,
            'pageSize': this.pageSize,
            'organInfo': {
              'organName': this.condition.organName,
              'organCode': this.condition.organCode
            }
          }
        }).then((res) => {
          if (!!res.data.code && 10000 == res.data.code) {
            let data = res.data.data
            this.dataCount = !!data['total'] ? data['total'] : 0
            this.organInfoArray = !!data['list'] ? data['list'] : []
          } else {
            this.$Message.error(!!res.data && !!res.data.message ? res.data.message : '获取科室列表数据失败')
          }
        })
      },
      closeModal () {
        this.maskModal = false
      },
       //删除器官信息
	   delOrganInfo(rows) {
	       this.$Modal.confirm({
	          title: '确认信息',
	          content: '<p1>确认删除该器官？</p1>',
	          onOk: () => {
	            let organData = JSON.parse(JSON.stringify(rows))
	            this.$axios.ajax({
	              method: 'post',
	              url: '/organ/delOrganInfo',
	              data: organData
	            }).then((res) => {
	              if (!!res.data.code && 10000 == res.data.code) {
	                this.$Message.success('删除成功')
	                this.getOrganInfoList()
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
	    
      //保存器官信息
      saveOrganInfo () {
        this.$refs['editFormItem'].validate((valid) => {
          if (valid) {
            this.$axios.ajax({
              method: 'post',
              url: '/organ/saveOrUpdateOrganInfo',
              data: this.editFormItem
            }).then((res) => {
              if (!!res.data.code && 10000 == res.data.code) {
                this.$Message.success('保存器官信息成功')
                this.getOrganInfoList()
                this.maskModal = false
              } else {
                this.$Message.error(!!res.data && !!res.data.msg ? res.data.msg : '保存疾病信息失败')
              }
            })
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
                this.getOrganInfoList()
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
      this.getOrganInfoList()//获取器官信息列表
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
