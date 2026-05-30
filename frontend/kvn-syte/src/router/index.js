import { createRouter, createWebHistory } from 'vue-router'
import MainApp from '@/components/MainApp.vue'
import AdminApp from '@/components/AdminApp.vue'
import LogViewer from '@/components/LogViewer.vue'
import ProfileViewer from '@/components/ProfileViewer.vue'
import EditorApp from '@/components/EditorApp.vue'
import NewPostEditor from '@/components/NewPostEditor.vue'
import TableViewer from '@/components/TableViewer.vue'

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
        component: LogViewer
      },
      {
        path: 'table',
        name: 'Tables',
        component: TableViewer
      },
      {
        path: 'profile',
        name: 'Profiles',
        component: ProfileViewer
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