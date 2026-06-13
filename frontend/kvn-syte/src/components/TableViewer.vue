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
                <option value="contest"> Конкурсы </option>
                <option value="team"> Команды </option>
                <option value="score"> Расписание игр </option>
                <option value="result"> Результаты игр </option>
                <option value="own"> Свой тип </option>
            </select>
        </div>
        <div class="ui divider"></div>
        <ContestTable v-if="tableType == 'contest'"/>
        <ResultTable v-if="tableType == 'result'"/>
        <TeamTable v-if="tableType == 'team'"/>
        <ScheduleTable v-if="tableType == 'score'"/>
        <TableListWindow v-if="listTable" @quit="listTable = false"/>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import ContestTable from './tables/ContestTable.vue';
import ResultTable from './tables/ResultTable.vue';
import ScheduleTable from './tables/ScheduleTable.vue';
import TeamTable from './tables/TeamTable.vue';
import TableListWindow from './windows/TableListWindow.vue';

const tableType = ref('none')
const listTable = ref(false)
</script>