<template>
    <div class="ui container">
        <button class="ui button" @click="listTable = true">
            <i class="edit icon"/> Открыть готовую таблицу
        </button>
        <h3 class="ui header">
            <div class="content">
                Тип таблицы
            </div>
        </h3>
        <div class="ui divider"></div>
        <div class="field">
            <select class="ui fluid dropdown" v-model="tableType">
                <option value="schedule"> Расписание игр </option>
                <option value="contest"> Конкурсы </option>
                <option value="team"> Команды </option>
                <option value="result"> Результаты игр </option>
                <option value="reward"> Награды </option>
                <option value="own"> Свой тип </option>
            </select>
        </div>
        <div class="ui divider"></div>
        <ContestTable v-if="tableType == 'contest'" :table="table" :title="table.title"/>
        <ResultTable v-if="tableType == 'result'" :table="table"/>
        <TeamTable v-if="tableType == 'team'" :table="table"/>
        <ScheduleTable v-if="tableType == 'schedule'" :table="table"/>
        <RewardTable v-if="tableType == 'reward'" :table="table"/>
        <CustomTable v-if="tableType == 'own'" :table="table"/>
        <TableListWindow v-if="listTable" @quit="listTable = false" @select="(t) => selectTable(t)"/>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import ContestTable from './tables/ContestTable.vue';
import ResultTable from './tables/ResultTable.vue';
import ScheduleTable from './tables/ScheduleTable.vue';
import TeamTable from './tables/TeamTable.vue';
import TableListWindow from './windows/TableListWindow.vue';
import RewardTable from './tables/RewardTable.vue';
import CustomTable from './tables/CustomTable.vue';

const tableType = ref('none')
const listTable = ref(false)
const table = ref({
    title: ""
})

function selectTable(t){
    tableType.value = t.type
    listTable.value = false

    table.value.title = t.title
    if (t.type == 'team'){
        table.value.teams = ref([
            {
                teamName: 'ЖХК',
                description: '---',
                isVisible: false
            },
            {
                teamName: 'Правило трёх',
                description: '---',
                isVisible: false
            },
            {
                teamName: 'Хлорид Натрия',
                description: '---',
                isVisible: false
            }
        ])
    }else if(t.type == 'contest'){
        table.value.contests = [
            {
                name: 'Визитка',
                description: '---',
                isVisible: false  // !!!
            },
            {
                name: 'Разминка',
                description: '---',
                isVisible: false  // !!!
            },
            {
                name: 'Капитанский конкурс',
                description: '---',
                isVisible: false  // !!!
            },
            {
                name: 'Музыкальное домашнее задание',
                description: '---',
                isVisible: false  // !!!
            }
        ]
    }else if(t.type == 'schedule'){
        table.value.games = [
            {
                gameName: 'Кубок работающей молодёжи',
                gameDate: '',
                isVisible: false
            },
            {
                gameName: 'Музыкальный фестиваль',
                gameDate: '',
                isVisible: false
            }
        ]
    }else if(t.type == 'result'){
        table.value.results = {
            columns: ['Визитка', 'Разминка', 'Сложная ситуация'],
            rows: [
            {
                team: 'ЖХК',
                rates: [3, 3, 3],
                isVisible: false
            },
            {
                team: 'Правило трёх',
                rates: [3, 3, 3],
                isVisible: false
            }]
        }
    }else if(t.type == 'reward'){
        table.value.rewards = [
            {
                description: "Лучшая мужская роль",
                to: "Алексей Макаров из 'Правило трёх'",
                isVisible: false  // !!!
            },
            {
                description: "Лучшая женская роль",
                to: "Саша Нивина из '35 элемент'",
                isVisible: false  // !!!
            }
        ]
    }
}
</script>