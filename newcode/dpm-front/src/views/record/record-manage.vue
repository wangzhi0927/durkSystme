<template>
  <div class="record-content">
    <i-form inline :label-width="80">
      <i-form-item prop="name" inline label="病人编号">
        <i-input type="text" v-model="condition.patientId" placeholder="请输入病人编号">
        </i-input>
      </i-form-item>
      <i-form-item prop="name" inline label="住院号">
        <i-input type="text" v-model="condition.inpNo" placeholder="请输入住院号">
        </i-input>
      </i-form-item>
      <i-form-item :label-width="20">
        <i-button type="primary" @click="getRecordList()">查询</i-button>
      </i-form-item>
    </i-form>
    <div>
      <i-table border :columns="recordColumns"
               :data="recordArray" class="record_grid"></i-table>
    </div>
    <div style="margin: 10px;overflow: hidden">
      <div style="float: right;">
        <i-page :total="dataCount" :page-size="pageSize" :current.sync="currentPage" show-total
                @on-change="changePage"></i-page>
      </div>
    </div>
  </div>
</template>

<script>
  import util from '@/libs/util'

  export default {
    name: 'record-manage',
    data () {
      return {
        baseUrl: util.getBaseUrl(),
        videoName: '谈话记录.mp4',//
        agreeFileName: '知情同意书.docx',
        authFileName: 'sqwts.docx',
        condition: {},
        currentPage: 1,
        // 初始化信息总条数
        dataCount: 0,
        // 每页显示多少条
        pageSize: 10,
        recordArray: [],
        recordColumns: [
          {
            title: '病人标识',
            key: 'patientId'
          },
          {
            title: '住院号',
            key: 'inpNo'
          },
          {
            title: '主诊断',
            key: 'diagName'
          },
          {
            title: '谈话类型',
            key: 'talkType'
          },
          {
            title: '档案名称',
            key: 'recordName'
          },
          {
            title: '下载',
            key: 'action',
            width: 300,
            align: 'center',
            render: (h, params) => {
              return h('div', [
                h('i-button', {
                  props: {
                    type: 'primary',
                    size: 'small'
                  },
                  style: {
                    marginRight: '5px'
                  },
                  on: {
                    click: () => {
                      this.downloadRecordFile(params.row, this.authFileName)
                    }
                  }
                }, '授权委托书'),
                h('i-button', {
                  props: {
                    type: 'primary',
                    size: 'small'
                  },
                  style: {
                    marginRight: '5px'
                  },
                  on: {
                    click: () => {
                      this.downloadRecordFile(params.row, this.agreeFileName)
                    }
                  }
                }, '知情同意书'),
                h('i-button', {
                  props: {
                    type: 'primary',
                    size: 'small'
                  },
                  style: {
                    marginRight: '5px'
                  },
                  on: {
                    click: () => {
                      this.downloadRecordFile(params.row, this.videoName)
                    }
                  }
                }, '谈话记录')])
            }
          }
        ]
      }
    },
    methods: {
      downloadRecordFile (rows, name) {
        if (!rows || !rows.foldPath) {
          this.$Message.error('文件路径不存在，无法下载')
          return false
        }
        let filePath = rows.foldPath + '/' + rows.id + name;
        this.$axios.ajax({
          method: 'get',
          url: '/record/validRecordFile?filePath=' + filePath,
          data: {}
        }).then((res) => {
          if (!!res.data.code && 10000 == res.data.code) {
            let url = this.baseUrl + '/record/downRecordFile?filePath=' + filePath
            let link = document.createElement('a')
            link.style.display = 'none'
            link.href = url
            link.setAttribute('download', name)
            document.body.appendChild(link)
            link.click()
          } else {
            this.$Message.error(!!res.data && !!res.data.msg ? res.data.msg : '下载资源文件失败')
          }
        })
      },
      changePage (index) {
        this.getRecordList(index)
      },
      //获取资源信息
      getRecordList (pageIndex) {
        this.recordArray = []
        if (isNaN(pageIndex)) {
          this.currentPage = 1
        }
        this.$axios.ajax({
          method: 'post',
          url: '/record/getRecordInfoByCondition',
          data: {
            'pageNum': !isNaN(pageIndex) ? pageIndex : 1,
            'pageSize': this.pageSize,
            'recordInfo': {
              'patientId': this.condition.patientId,
              'inpNo': this.condition.inpNo
            }
          }
        }).then((res) => {
          if (!!res.data.code && 10000 == res.data.code) {
            let data = res.data.data
            this.dataCount = !!data['total'] ? data['total'] : 0
            this.recordArray = !!data['list'] ? data['list'] : []
          } else {
            this.$Message.error(!!res.data && !!res.data.msg ? res.data.msg : '获取记录列表数据失败')
          }
        })
      }
    },
    created () {
      this.getRecordList()//获取资源列表
    }
  }
</script>

<style scoped>
  .record-content {
    width: 100%;
    height: 100%;
  }

  .record_grid {
    height: calc(100vh - 240px);
    overflow: auto;
  }

</style>
