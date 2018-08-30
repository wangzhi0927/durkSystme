<template>
  <div class="disease-content">
    <i-form inline :label-width="80">
      <i-row>
         <i-form-item prop="diseaseName" inline label="疾病名称">
          <i-input type="text" v-model="condition.diseaseName" placeholder="请输入检索疾病名称">
          </i-input>
        </i-form-item>
        <i-form-item :label-width="20">
          <i-button type="primary" @click="getTnmInfoList()" icon="ios-search">查询</i-button>
          <i-button type="primary" @click="showMask()"  icon="plus">新增</i-button>
        </i-form-item>
      </i-row>
      </i-form>
    <div>
      <i-table border stripe :loading="false" :columns="tnmInfoColumns" :data="tnmInfoArray" class="disease_grid"></i-table>
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
            <i-form-item label="疾病" prop="diseaseCode">
              <i-select clearable filterable
                        v-model="editFormItem.diseaseCode"
                        placeholder="请选择待筛选疾病" @on-change="getKey" label-in-value>
                <i-option v-for="(item,index) in maskDiseaseArray" :value="item.diseaseCode"
                          :key="item.diseaseName">{{
                  item.diseaseName }}
                </i-option>
              </i-select>
            </i-form-item>
          </i-col>
        </i-row>
        <i-row>
          <i-col span="9">
            <i-form-item label="类型" prop="type">
              <i-select v-model="editFormItem.type" placeholder="请选择类别">
                <i-option value="0">T</i-option>
                <i-option value="1">M</i-option>
              </i-select>
            </i-form-item>
          </i-col>
        </i-row>
        <i-row>
          <i-col span="12">
          	<i-form-item label="描述" prop="description">
              <i-input placeholder="请输入描述" v-model="editFormItem.description"  style="width:180px"></i-input>
            </i-form-item>
          </i-col>
        </i-row>
         <i-row>
          <i-col span="12">
            <i-form-item label="文件名称">
              <i-input readonly :value="editFormItem.fileName"></i-input>
            </i-form-item>
          </i-col>
          <i-col span="6">
            <i-form-item label="文件大小">
              <i-input readonly :value="editFormItem.size">
                <span slot="append">KB</span>
              </i-input>
            </i-form-item>
          </i-col>
          <i-col span="6">
            <i-form-item v-show="editFormItem.type==='2'" label="文件时长">
              <i-input readonly :value="editFormItem.duration">
                <span slot="append">秒</span>
              </i-input>
            </i-form-item>
          </i-col>
        </i-row>
        <i-form-item label="资源附件">
          <a @click="downloadResourceFile">{{editFormItem.fileName}}</a>
          <i-upload :show-upload-list="notShowUploadList" multiple :action="uploadAction" :on-success="uploadModels"
                    :before-upload="beforeLoad"
                    :on-error="uploadFailed"
                    name="upfile" :headers=headers
                    style="float: right;width: 60px;margin-right: 20px"
                    :data=editFormItem>
            <i-button type="ghost" icon="ios-cloud-upload-outline">上传</i-button>
          </i-upload>
          <a v-show="!!editFormItem.fileName" style="float: right;color: #ed3f14;padding-right: 30px"> *
            已存在附件【{{editFormItem.fileName }}】，继续上传操作将覆盖原有文件
          </a>
        </i-form-item>
      </i-form>
      <div slot="footer">
        <i-button type="primary" size="large" @click="saveTNMInfo">保存</i-button>
        <i-button type="ghost" @click="closeModal" size="large">关闭</i-button>
      </div>
      <i-spin size="large" fix v-if="loadingModal">
        <i-icon type="load-c" size=25 class="demo-spin-icon-load"></i-icon>
        <div style="font-size: large">上传资源中,请耐心等待...</div>
      </i-spin>
    </i-modal>
  </div>
</template>

<script>
  import Cookies from 'js-cookie'
  import util from '@/libs/util'
  
  export default {
    name: 'organ-manager',
    data () {
      return {
        condition: {
          diseaseName: ''
        },
        uploadAction: util.getBaseUrl() + '/tnm/fileUpload',
        baseUrl: util.getBaseUrl(),
        notShowUploadList: false,
        tnmInfoArray: [],//tnm信息数据
        maskDiseaseArray: [],//疾病列表数据
        currentPage: 1,
        loading:false,
        dieaseDisabled:false,
        key:'',
        emptyMask: {
          id: '',
          diseaseCode:'',
          diseaseName:'',
          url:'',
          description:'',
          operatorType:'0'
        },
        headers: {
          token: Cookies.get('token')
        },
        loadingModal: false,
        maskTitle: 'tnm信息维护',
        editFormItem: {},
        maskModal: false,
        // 初始化信息总条数
        dataCount: 0,
        // 每页显示多少条
        pageSize: 13,
        tnmInfoColumns: [
          {
            title: '疾病编码',
            key: 'diseaseCode'
          },
          {
            title: '疾病名称',
            key: 'diseaseName'
          },
          {
            title: '文件名称',
            key: 'url',
            render: (h, params) => {
              return h('div', [
                h('strong', this.getLabelByUrl(params.row.url))
              ]);
            }
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
            title: '描述',
            key: 'description'
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
                      this.delTNMInfo(params.row)
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
          dieaseCode: [
            { required: true, message: '请选择疾病', trigger: 'blur' }
          ],
          modelOperation: [
            { required: true, message: 'Please select the modelOperation', trigger: 'blur' }
          ]
        }
      }
    },

    methods: {
      getLabelByType(type){
        let label = ''
        switch (type){
          case '0':
            label='T'
            break
          case '1':
            label='M'
            break
          default:
        }
        return label
      },
      getLabelByUrl(url){
        let label = '';
        let urlArray = url.split('/');
        if(!!urlArray){
        	label = urlArray[urlArray.length-1];
        }
        return label
      },
      // 获取历史记录信息
      changePage (index) {
        this.getTnmInfoList(index)
      },
      // 获取历史记录信息
      getKey(index) {
      	if(!!index.label){
        	this.editFormItem.diseaseName = index.label
        }
      },
      //弹出用户辑窗口
      showMask (rows) {
        this.editFormItem = JSON.parse(JSON.stringify(this.emptyMask));
        this.dieaseDisabled = false;
        this.key = '';
        if (!!rows) {
          	let dataRow = JSON.parse(JSON.stringify(rows));
          	this.editFormItem = dataRow;
          	this.dieaseDisabled = true;
          	this.key = this.editFormItem.diseaseCode;
        }
        this.getDiseaseList(this.key).then((res) => {
          if (!!res.data.code && 10000 == res.data.code) {
            this.maskDiseaseArray = JSON.parse(JSON.stringify(res.data.data))
          } else {
            this.$Message.error(!!res.data && !!res.data.msg ? res.data.msg : '获取疾病信息失败')
          }
        })
        
        this.maskModal = true
      },
      
      closeModal(){
        this.maskModal = false
      },
      
       //获取器官信息
      getTnmInfoList (pageIndex) {
        this.tnmInfoArray = []
        if (isNaN(pageIndex)) {
          this.currentPage = 1
        }
        this.$axios.ajax({
          method: 'post',
          url: '/tnm/getTnmInfoByCondition',
          data: {
            'pageNum': !isNaN(pageIndex) ? pageIndex : 1,
            'pageSize': this.pageSize,
            'tTnmInfo': {
              'diseaseName': this.condition.diseaseName
            }
          }
        }).then((res) => {
          if (!!res.data.code && 10000 == res.data.code) {
            let data = res.data.data
            this.dataCount = !!data['total'] ? data['total'] : 0
            this.tnmInfoArray = !!data['list'] ? data['list'] : []
          } else {
            this.$Message.error(!!res.data && !!res.data.message ? res.data.message : '获取tnm列表数据失败')
          }
        })
      },

      //获取疾病列表
      getDiseaseList (key) {
        return this.$axios.ajax({
          method: 'get',
          url: '/model/getTnmDiseaseList',
          data: {}
        })
      },
      
      beforeLoad (e) {
        this.loadingModal = true
      },
       //上传文件
      uploadModels (response, file, fileList) {
        if (!!response.code && 10000 == response.code) {
          if (Array.isArray(response.data) && response.data.length > 0) {
            this.editFormItem.fileName = response.data[0]['fileName']
            this.editFormItem.path = response.data[0]['path']
            this.editFormItem.size = response.data[0]['size']
            this.editFormItem.duration = response.data[0]['duration']
            this.editFormItem.url = response.data[0]['path']
          }
        } else {
          this.$Message.error(!!response.msg ? response.msg : '上传资源列表数据失败')
        }
        this.loadingModal = false
      },
      downloadResourceFile () {
        let url = this.baseUrl + '/model/downResourceFile?filePath=' + this.editFormItem.path
        let link = document.createElement('a')
        link.style.display = 'none'
        link.href = url
        link.setAttribute('download', this.editFormItem.fileName)
        document.body.appendChild(link)
        link.click()
      },
      
      uploadFailed (response, file, fileList) {
        this.loadingModal = false
        this.$Message.error(!!response.msg ? response.msg : '上传资源列表数据失败')
      },
       //删除器官信息
	   delTNMInfo(rows) {
	       this.$Modal.confirm({
	          title: '确认信息',
	          content: '<p1>确认删除该数据？</p1>',
	          onOk: () => {
	            let tnmData = JSON.parse(JSON.stringify(rows))
	            this.$axios.ajax({
	              method: 'post',
	              url: '/tnm/delTnmInfo',
	              data: tnmData
	            }).then((res) => {
	              if (!!res.data.code && 10000 == res.data.code) {
	                this.$Message.success('删除成功')
	                this.getTnmInfoList()
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
	    
      //保存tnm信息
      saveTNMInfo () {
        this.$refs['editFormItem'].validate((valid) => {
          if (valid) {
            this.$axios.ajax({
              method: 'post',
              url: '/tnm/saveOrUpdateTnmInfo',
              data: this.editFormItem
            }).then((res) => {
              if (!!res.data.code && 10000 == res.data.code) {
                this.$Message.success('保存tnm信息成功')
                this.getTnmInfoList()
                this.maskModal = false
              } else {
                this.$Message.error(!!res.data && !!res.data.msg ? res.data.msg : '保存疾病信息失败')
              }
            })
          }
        })
      },
    },
    created () {
      this.getTnmInfoList()//获取tnm信息列表
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
