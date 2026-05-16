import { createRouter, createWebHistory } from 'vue-router'
import MainApp from '@/components/MainApp.vue'
import AdminApp from '@/components/AdminApp.vue'
import LogTable from '@/components/LogTable.vue'
import ProfileTable from '@/components/ProfileTable.vue'
import EditorApp from '@/components/EditorApp.vue'
import NewPostEditor from '@/components/NewPostEditor.vue'
import TableView from '@/components/TableView.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: MainApp
  },
  {
    path: '/admin',
    name: 'Admin Home',
    component: AdminApp,
    children: [
      {
        path: 'log',
        name: 'Logs',
        component: LogTable
      },
      {
        path: 'table',
        name: 'Tables',
        component: TableView
      },
      {
        path: 'profile',
        name: 'Profiles',
        component: ProfileTable
      }
    ]
  },
  {
    path: '/editor',
    name: 'Editor Home',
    component: EditorApp,
    children: [
      {
        path: 'new-post',
        name: 'New Post',
        component: NewPostEditor
      }
    ]
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL), 
  routes
})

export default router