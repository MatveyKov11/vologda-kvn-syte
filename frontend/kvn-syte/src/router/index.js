import { createRouter, createWebHistory } from 'vue-router'
import MainApp from '@/components/MainApp.vue'
import AdminApp from '@/components/AdminApp.vue'
import ContestTable from '@/components/ContestTable.vue'
import TeamTable from '@/components/TeamTable.vue'
import ScheduleTable from '@/components/ScheduleTable.vue'
import ResultTable from '@/components/ResultTable.vue'
import LogTable from '@/components/LogTable.vue'
import ProfileTable from '@/components/ProfileTable.vue'

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
            path: 'contest',
            name: 'Contests',
            component: ContestTable
        },
        {
            path: 'team',
            name: 'Teams',
            component: TeamTable
        },
        {
            path: 'schedule',
            name: 'Schedule',
            component: ScheduleTable
        },
        {
            path: 'result',
            name: 'Results',
            component: ResultTable
        },
        {
            path: 'log',
            name: 'Logs',
            component: LogTable
        },
        {
            path: 'profile',
            name: 'Profiles',
            component: ProfileTable
        }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL), 
  routes
})

export default router