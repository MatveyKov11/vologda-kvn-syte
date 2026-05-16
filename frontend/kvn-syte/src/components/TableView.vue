<template>
    <div class="ui text container">
        <h3 class="ui header">
            <div class="content">
                Тип таблицы
            </div>
        </h3>
    </div>
    <div class="field">
        <select class="ui fluid dropdown" v-model="tableType">
            <option value="contest"> Конкурсы </option>
            <option value="team"> Команды </option>
            <option value="score"> Расписание игр </option>
            <option value="results"> Результаты игр </option>
            <option value="own"> Свой тип </option>
        </select>
    </div>
    <ContestTable v-if="tableType == 'contest'"></ContestTable>
    <ResultTable v-if="tableType == 'results'"></ResultTable>
    <TeamTable v-if="tableType == 'team'"></TeamTable>
    <ScheduleTable v-if="tableType == 'score'"></ScheduleTable>
</template>

<script setup>
import { ref } from 'vue';
import ContestTable from './ContestTable.vue';
import ResultTable from './ResultTable.vue';
import ScheduleTable from './ScheduleTable.vue';
import TeamTable from './TeamTable.vue';

const tableType = ref('none')
</script>