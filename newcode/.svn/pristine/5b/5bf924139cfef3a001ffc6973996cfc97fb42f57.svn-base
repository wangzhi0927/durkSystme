<template>
  <div class="dept-content">
    <i-form inline :label-width="80">
      <i-row>
        <i-form-item prop="deptName" inline label="科室名">
          <i-input type="text" v-model="condition.deptName" placeholder="请输入检索科室名">
          </i-input>
        </i-form-item>

        <i-form-item prop="state" label="状态">
          <i-select clearable v-model="condition.state" style="width:160px" placeholder="请选择待筛选状态">
            <i-option value="0">启用</i-option>
            <i-option value="1">停用</i-option>
          </i-select>
        </i-form-item>
        <i-form-item :label-width="20">
          <i-button type="primary" @click="getDeptInfoList()" icon="ios-search">查询</i-button>
          <i-button type="primary" @click="showMask()"  icon="plus">新增</i-button>
        </i-form-item>
      </i-row>
      </i-form>
    <div>
      <i-table border stripe :columns="deptInfoColumns" :data="deptInfoArray" class="dept_grid"></i-table>
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
      <i-form ref="editFormItem" :model="editFormItem" :label-width="80" :rules="ruleValidate">
        <i-row>
            <i-form-item label="科室名称" prop="deptName">
              <i-input placeholder="请输入科室名称" v-model="editFormItem.deptName" style="width:550px"></i-input>
            </i-form-item>
            <i-form-item label="英文名称" prop="enName">
              <i-input placeholder="请输入英文名称" v-model="editFormItem.enName" style="width:550px"></i-input>
            </i-form-item>
            <i-form-item prop="enabled" label="状态">
              <i-select v-model="editFormItem.enabled" style="width:550px" placeholder="请选择待筛选状态">
                <i-option value="0">启用</i-option>
                <i-option value="1">停用</i-option>
              </i-select>
            </i-form-item>
            <i-form-item  label="描述" prop="comment">
              <i-input type="textarea" :rows="4" v-model="editFormItem.comment" placeholder="请输入描述信息" style="width:550px" >
              </i-input>
            </i-form-item>
        </i-row>
      </i-form>
      <div slot="footer">
        <i-button type="primary" size="large" @click="saveDeptInfo" v-show="editFormItem.operatorType!=='2'">保存</i-button>
        <i-button type="ghost" @click="closeModal" size="large">关闭</i-button>
      </div>
    </i-modal>
  </div>
</template>

<script>
  import Cookies from 'js-cookie'

  export default {
    name: 'dept-manager',
    data () {
      return {
        condition: {
          deptName: '',//过滤条件科室名称
          state:''//状态
        },
        deptList:[],//科室列表数据
        deptInfoArray: [],//用户信息数据
        currentPage: 1,
        emptyMask: {
          id: '',
          hosCode:JSON.parse(Cookies.get('userInfo')).hosCode,
          deptCode: '',
          deptName:'',
          enName:'',
          comment:'',
          enabled:'',
          createUser:'',
          modifyUser:'',
          operatorType:'0'
        },
        headers: {
          token: Cookies.get('token')
        },
        maskTitle: '科室信息维护',
        editFormItem: {},
        maskModal: false,
        // 初始化信息总条数
        dataCount: 0,
        // 每页显示多少条
        pageSize: 13,
        deptInfoColumns: [
          {
            title: '科室名',
            key: 'deptName'
          },
          {
            title: '描述',
            key: 'comment',
          },
          {
            title: '英文名称',
            key: 'enName'
          },
          {
            title: '状态',
            key: 'enabled',
            render: (h, params) => {
              return h('div', [
                h('strong', this.getLabelByCode(params.row.enabled))
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
                }, '查看')
              )
              params.row.enabled==='0' && btns.push(
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
              params.row.enabled==='1' && btns.push(
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
          deptName: [
            { required: true, message: 'The deptName cannot be empty', trigger: 'blur' }
          ],
          enabled: [
            { required: true, message: 'The state cannot be empty', trigger: 'change' }
          ]
        }
      }
    },

    methods: {
      getLabelByCode(code){
       let label = ''
        switch (code){
          case '0':
            label='启用中'
            break
          case '1':
            label='已停用'
            break
          default:
        }
        return label
      },
      // 获取历史记录信息
      changePage (index) {
        this.getDeptInfoList(index)
      },
      //弹出用户辑窗口
      showMask (rows) {
        this.editFormItem = JSON.parse(JSON.stringify(this.emptyMask))
        if (!!rows) {
          this.editFormItem = JSON.parse(JSON.stringify(rows))
        }
        this.maskModal = true
      },
      //获取科室信息
      getDeptInfoList (pageIndex) {
        this.deptInfoArray = []
        if (isNaN(pageIndex)) {
          this.currentPage = 1
        }
        this.$axios.ajax({
          method: 'post',
          url: '/dept/getDeptInfoByCondition',
          data: {
            'pageNum': !isNaN(pageIndex) ? pageIndex : 1,
            'pageSize': this.pageSize,
            'deptInfo': {
              'deptName': this.condition.deptName,
              'enabled': this.condition.state,
              'hosCode': JSON.parse(Cookies.get('userInfo')).hosCode
            }
          }
        }).then((res) => {
          if (!!res.data.code && 10000 == res.data.code) {
            let data = res.data.data
            this.dataCount = !!data['total'] ? data['total'] : 0
            this.deptInfoArray = !!data['list'] ? data['list'] : []
          } else {
            this.$Message.error(!!res.data && !!res.data.message ? res.data.message : '获取科室列表数据失败')
          }
        })
      },
      closeModal () {
        this.maskModal = false
      },
      //保存用户信息
      saveDeptInfo () {
        this.$refs['editFormItem'].validate((valid) => {
          if (valid) {
            if(!!this.editFormItem.createUser)
              this.editFormItem.modifyUser=JSON.parse(Cookies.get('userInfo')).name
            else
              this.editFormItem.createUser = JSON.parse(Cookies.get('userInfo')).name
            this.$axios.ajax({
              method: 'post',
              url: '/dept/saveOrUpdateDeptInfo',
              data: this.editFormItem
            }).then((res) => {
              if (!!res.data.code && 10000 == res.data.code) {
                this.$Message.success('保存科室信息成功')
                this.getDeptInfoList()
                this.maskModal = false
              } else {
                this.$Message.error(!!res.data && !!res.data.msg ? res.data.msg : '保存科室信息失败')
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
            let deptData = JSON.parse(JSON.stringify(rows))
            deptData.modifyUser = JSON.parse(Cookies.get('userInfo')).name
            this.$axios.ajax({
              method: 'post',
              url: '/dept/changDeptStateById',
              data: deptData
            }).then((res) => {
              if (!!res.data.code && 10000 == res.data.code) {
                this.$Message.success('状态更改成功')
                this.getDeptInfoList()
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
      this.getDeptInfoList()//获取科室信息列表
    }
  }
</script>

<style>
  .dept-content {
    width: 100%;
    height: 100%;
  }

  .dept_grid {
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
